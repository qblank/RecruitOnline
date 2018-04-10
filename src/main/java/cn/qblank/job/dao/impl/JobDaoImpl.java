package cn.qblank.job.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.job.dao.IJobDao;
import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.Position;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class JobDaoImpl implements IJobDao{
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Firm findById(Integer id) {
		return sessionFactory.getCurrentSession().get(Firm.class, id);
	}

	@Override
	public List<Firm> findCateById(Serializable id,Integer page,Integer pageSize) {
		Query q = sessionFactory.getCurrentSession().createQuery("from Firm where fcid = ?")
				.setParameter(0, id);
		q.setFirstResult(page);
		q.setMaxResults(pageSize);
		List<Firm> firms = q.list();
		return firms;
	}

	@Override
	public Position findPosById(Integer id) {
		return sessionFactory.getCurrentSession().get(Position.class, id);
	}

	@Override
	public List<Position> findPosByFirm(Firm firm) {
		/*String hql = " SELECT p FROM Firm f JOIN f.positions p JOIN Firm_t_position fp " + 
				"	WHERE fp.Firm_fid = f.fid " + 
				"	AND fp.positions_pid = p.pid " + 
				"	AND p.fid = fp.Firm_fid "
				+ " AND f.fid = ?";*/
		String hql = "SELECT p FROM Firm f INNER JOIN f.positions p" + 
				"	WHERE f.fid = p.fid" + 
				"	AND f.fid = ?";
		
		Query q = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter(0, firm.getFid());
		
		List<Position> positions = q.list();
		return positions;
	}
	
	
}

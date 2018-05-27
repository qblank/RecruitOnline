package cn.qblank.position.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.Position;
import cn.qblank.position.dao.IPositionDao;

@Repository
@Transactional
public class PositionDaoImpl implements IPositionDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Position findPosById(Integer pid) {
		return sessionFactory.getCurrentSession().get(Position.class, pid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAllPos(Integer fid) {
		Query q = sessionFactory.getCurrentSession().createQuery(" from Position where fid = ?").setParameter(0, fid);
		if (q.list().size() > 0) {
			return q.list();
		}
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAllPos() {
		return sessionFactory.getCurrentSession().createQuery("from Position").list();
	}

	@Override
	public int countPos() {
		Criteria createria = sessionFactory.getCurrentSession().createCriteria(Position.class);
		//获取数据表的投影
		createria.setProjection(Projections.rowCount());
		//得到数据总条数
		return createria.list().size();
	}

	@Override
	public List<Position> findByName(String searchName) {
		Query q = sessionFactory.getCurrentSession().createQuery("from Position where pname like '%" + searchName +"%'");
		List<Position> positions = q.list();
		if (positions != null &&positions.size() > 0) {
			return positions;
		}
		return null;
	}

}

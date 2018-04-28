package cn.qblank.position.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}

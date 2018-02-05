package dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.qblank.dao.IBaseDao;

//@Repository("BaseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements IBaseDao<T>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(String hql, Object[] param) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {  
                q.setParameter(i, param[i]);  
            }  
        }  
		return (T) q.list().get(0);
	}
	
}

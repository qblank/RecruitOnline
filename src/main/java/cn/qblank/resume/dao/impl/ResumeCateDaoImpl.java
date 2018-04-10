package cn.qblank.resume.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.resume.dao.IResumeCateDao;
import cn.qblank.resume.entity.ResumeCate;

@Repository
@Transactional
public class ResumeCateDaoImpl implements IResumeCateDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ResumeCate resumeCate) {
		sessionFactory.getCurrentSession().save(resumeCate);
	}
	
}

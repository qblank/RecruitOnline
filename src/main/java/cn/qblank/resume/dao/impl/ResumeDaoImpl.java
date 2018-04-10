package cn.qblank.resume.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.resume.dao.IResumeDao;
import cn.qblank.resume.entity.Resume;

@Repository
@Transactional
public class ResumeDaoImpl implements IResumeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdateResume(Resume resume) {
		sessionFactory.getCurrentSession().saveOrUpdate(resume);
	}

	@Override
	public Resume findResumeById(Serializable id) {
		 return sessionFactory.getCurrentSession().get(Resume.class, id);
	}
	
	
}

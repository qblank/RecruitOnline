package cn.qblank.resume.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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
	@SuppressWarnings("unchecked")
	public Resume findResumeByUid(Serializable id) {
		List<Resume> resumes = sessionFactory.getCurrentSession().createQuery("from Resume where uid = ?")
				 .setParameter(0, id).list();
		 if (resumes.size() > 0) {
			return resumes.get(0);
		}
		return null;
	}

	@Override
	public void save(Resume resume) {
		sessionFactory.getCurrentSession().save(resume);
	}

	@Override
	public void update(Resume resume) {
		sessionFactory.getCurrentSession().update(resume);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resume> findAllResume(String status) {
		String hql = "from Resume where status = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql)
			.setParameter(0, status);
		List<Resume> resumes = q.list();
		return resumes;
	}
	
	
}

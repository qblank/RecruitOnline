package cn.qblank.job.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.job.dao.IJobCateDao;
import cn.qblank.job.entity.FirmCate;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class JobCateDaoImpl implements IJobCateDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<FirmCate> findAllFirmCate() {
		return sessionFactory.getCurrentSession().createQuery("from FirmCate").list();
	}

}

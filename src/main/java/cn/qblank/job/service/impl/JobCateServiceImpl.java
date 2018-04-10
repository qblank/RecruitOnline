package cn.qblank.job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.job.dao.IJobCateDao;
import cn.qblank.job.entity.FirmCate;
import cn.qblank.job.service.IJobCateService;
@Service
public class JobCateServiceImpl implements IJobCateService{
	@Autowired
	private IJobCateDao jobCateDao;

	@Override
	public List<FirmCate> findAllFirmCate() {
		return jobCateDao.findAllFirmCate();
	}

}

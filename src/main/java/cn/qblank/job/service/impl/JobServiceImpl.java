package cn.qblank.job.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.job.dao.IJobDao;
import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.Position;
import cn.qblank.job.service.IJobService;

@Service
public class JobServiceImpl implements IJobService{
	
	@Autowired
	private IJobDao jobDao;
	
	@Override
	public Firm findById(Integer id) {
		return jobDao.findById(id);
	}

	@Override
	public List<Firm> findCateById(Serializable id, Integer page, Integer pageSize) {
		return jobDao.findCateById(id, page, pageSize);
	}

	@Override
	public Position findPosById(Integer id) {
		if (id != null) {
			return jobDao.findPosById(id);
		}
		return null;
	}

	@Override
	public List<Position> findPosByFirm(Firm firm) {
		return jobDao.findPosByFirm(firm);
	}

}

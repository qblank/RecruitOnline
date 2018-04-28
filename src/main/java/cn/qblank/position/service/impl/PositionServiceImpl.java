package cn.qblank.position.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.job.entity.Position;
import cn.qblank.position.dao.IPositionDao;
import cn.qblank.position.service.IPositionService;

@Service
public class PositionServiceImpl implements IPositionService{
	
	@Autowired
	private IPositionDao positionDao;

	@Override
	public Position findPosById(Integer pid) {
		return positionDao.findPosById(pid);
	}

	@Override
	public List<Position> findAllPos(Integer fid) {
		return positionDao.findAllPos(fid);
	}

	@Override
	public List<Position> findAllPos() {
		return positionDao.findAllPos();
	}

}

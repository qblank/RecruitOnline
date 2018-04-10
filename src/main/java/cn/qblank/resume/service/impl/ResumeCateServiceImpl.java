package cn.qblank.resume.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.resume.dao.IResumeCateDao;
import cn.qblank.resume.entity.ResumeCate;
import cn.qblank.resume.service.IResumeCateService;

@Service
public class ResumeCateServiceImpl implements IResumeCateService{
	@Autowired
	private IResumeCateDao resumeCateDao;

	@Override
	public void addResumeCate(ResumeCate resumeCate) {
		resumeCateDao.save(resumeCate);
	}
}

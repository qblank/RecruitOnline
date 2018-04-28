package cn.qblank.resume.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.resume.dao.IResumeDao;
import cn.qblank.resume.entity.Resume;
import cn.qblank.resume.service.IResumeService;

@Service
@Transactional
public class ResumeServiceImpl implements IResumeService{
	@Autowired
	private IResumeDao resumeDao;
	
	@Override
	public void saveOrUpdateResume(Resume resume) {
		resumeDao.saveOrUpdateResume(resume);
	}

	@Override
	public Resume findResumeByUid(Serializable id) {
		return resumeDao.findResumeByUid(id);
	}

	@Override
	public void save(Resume resume) {
		resumeDao.save(resume);
	}

	@Override
	public void update(Resume resume) {
		resumeDao.update(resume);
	}

	@Override
	public List<Resume> findAllResume(String status) {
		return resumeDao.findAllResume(status);
	}

}

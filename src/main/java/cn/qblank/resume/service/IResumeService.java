package cn.qblank.resume.service;

import java.io.Serializable;

import cn.qblank.resume.entity.Resume;

public interface IResumeService {
	/**
	 * 添加或修改简历信息
	 */
	public void saveOrUpdateResume(Resume resume);
	
	/**
	 * 通过编号查找简历
	 * @param id
	 * @return
	 */
	public Resume findResumeById(Serializable id);
	
	/**
	 * 添加简历信息
	 * @param resume
	 */
	public void save(Resume resume);
	
	/**
	 * 修改简历信息
	 * @param resume
	 */
	public void update(Resume resume);
}

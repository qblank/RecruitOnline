package cn.qblank.resume.dao;

import java.io.Serializable;

import cn.qblank.resume.entity.Resume;

public interface IResumeDao {
	/**
	 * 添加或者修改简历信息
	 * @param resume
	 */
	public void saveOrUpdateResume(Resume resume);
	/**
	 * 通过编号查找简历
	 * @param id
	 * @return
	 */
	public Resume findResumeById(Serializable id);
}

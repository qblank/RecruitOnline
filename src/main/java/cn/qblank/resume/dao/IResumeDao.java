package cn.qblank.resume.dao;

import java.io.Serializable;
import java.util.List;

import cn.qblank.resume.entity.Resume;

public interface IResumeDao {
	/**
	 * 添加或者修改简历信息
	 * @param resume
	 */
	public void saveOrUpdateResume(Resume resume);
	
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
	
	/**
	 * 通过用户编号查找简历
	 * @param id
	 * @return
	 */
	public Resume findResumeByUid(Serializable id);
	
	/**
	 * 查看所有公开简历
	 * 0: 保密
	 * 1:公开
	 * @return
	 */
	public List<Resume> findAllResume(String status);
	
}

package cn.qblank.resume.dao;

import cn.qblank.resume.entity.ResumeCate;

/**
 * 类别接口
 * @author evan_qb
 */
public interface IResumeCateDao {
	/**
	 * 添加类别
	 */
	void save(ResumeCate resumeCate);
}

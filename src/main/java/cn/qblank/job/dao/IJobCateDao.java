package cn.qblank.job.dao;

import java.util.List;

import cn.qblank.job.entity.FirmCate;

public interface IJobCateDao {
	/**
	 * 查询所有类别
	 * @return
	 */
	public List<FirmCate> findAllFirmCate();
}

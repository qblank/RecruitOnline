package cn.qblank.job.service;

import java.util.List;

import cn.qblank.job.entity.FirmCate;

public interface IJobCateService {
	/**
	 * 查询所有类别
	 * @return
	 */
	public List<FirmCate> findAllFirmCate();
}

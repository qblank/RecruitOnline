package cn.qblank.position.service;

import java.util.List;

import cn.qblank.job.entity.Position;

public interface IPositionService {
	/**
	 * 通过编号查找职位
	 * @return
	 */
	Position findPosById(Integer id);
	
	/**
	 * 通过公司编号查找所有职业
	 * @param id
	 * @return
	 */
	List<Position> findAllPos(Integer id);
	/**
	 * 查看所有职位
	 * @return
	 */
	List<Position> findAllPos();
	/**
	 * 获取所有职位数量
	 * @return
	 */
	int countPos();
	/**
	 * 搜索查出职位列表
	 * @param searchName
	 * @return
	 */
	List<Position> findByName(String searchName);
}

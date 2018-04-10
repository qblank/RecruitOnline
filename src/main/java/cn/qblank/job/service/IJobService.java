package cn.qblank.job.service;

import java.io.Serializable;
import java.util.List;

import cn.qblank.job.entity.Firm;
import cn.qblank.job.entity.Position;

public interface IJobService {
	/**
	 * 通过编号查找
	 * @param id
	 * @return
	 */
	Firm findById(Integer id);
	
	/**
	 * 分页查询某个类下的所有公司
	 * @return
	 */
	List<Firm> findCateById(Serializable id,Integer page,Integer pageSize);
	
	/**
	 * 通过编号查询职位
	 * @param id
	 * @return
	 */
	Position findPosById(Integer id);
	
	/**
	 * 通过公司查找该公司招聘的所有的职位
	 * @param firm
	 * @return
	 */
	List<Position> findPosByFirm(Firm firm);
}

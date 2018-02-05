package cn.qblank.dao;

import java.io.Serializable;

/**
 * 常用的增删操作
 * @author evan_qb
 *
 */
public interface IBaseDao<T> {
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public Serializable save(T o);
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T o);
	/**
	 * 修改
	 */
	public void update(T o);
	
	/**
	 * 保存或者更新
	 */
	public void saveOrUpdate(T o);
	
	/**
	 * 查询一个对象
	 */
	public T get(String hql,Object[] param);
	
	
}

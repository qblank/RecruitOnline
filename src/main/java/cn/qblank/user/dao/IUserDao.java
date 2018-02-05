package cn.qblank.user.dao;

import cn.qblank.user.entity.User;

public interface IUserDao {
	/**
	 * 修改
	 * @param user
	 */
	void saveUser(User user);
	/**
	 * 查询
	 */
	User Login(User user);
}

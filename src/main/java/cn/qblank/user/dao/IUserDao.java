package cn.qblank.user.dao;

import java.io.Serializable;

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
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param newPwd
	 * @param rePwd
	 * @return
	 */
	boolean revisePwd(User user);
	
	
	/***管理员***/
	
	/**
	 * 通过编号查找用户信息
	 * @param uid
	 * @return
	 */
	User findUserById(Integer uid);
}

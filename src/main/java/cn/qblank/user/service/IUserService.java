package cn.qblank.user.service;

import cn.qblank.user.entity.User;

public interface IUserService {
	/**
	 * 注册
	 * @param user
	 */
	void register(User user);
	
	/**
	 * 登录
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
}

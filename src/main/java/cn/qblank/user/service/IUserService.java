package cn.qblank.user.service;

import java.io.Serializable;

import cn.qblank.resume.entity.Resume;
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
	
	/**
	 * 通过编号查找用户信息
	 * @param uid
	 * @return
	 */
	User findUserById(Integer uid);
	
	/**
	 * 通过用户查简历
	 * @param user
	 * @return
	 */
	Resume findResumeByUser(User user);
}

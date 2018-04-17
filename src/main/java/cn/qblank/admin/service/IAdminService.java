package cn.qblank.admin.service;

import java.util.List;

import cn.qblank.user.entity.User;

public interface IAdminService {
	/**
	 * 通过权限编号查找非管理员的用户
	 * @param authority
	 * @return
	 */
	public List<User> findAllByAuthority(Integer authority);
	/**
	 * 通过编号删除用户
	 * @param uid
	 * @return
	 */
	public void deleteUserById(Integer uid);
	/**
	 * 修改用户
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
}

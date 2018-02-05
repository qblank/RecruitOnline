package cn.qblank.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.user.dao.IUserDao;
import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
}

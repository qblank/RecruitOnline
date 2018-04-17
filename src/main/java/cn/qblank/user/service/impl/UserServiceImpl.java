package cn.qblank.user.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.user.dao.IUserDao;
import cn.qblank.user.entity.User;
import cn.qblank.user.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;

	@Override
	public void register(User user) {
		user.setRegisterTime(new Date(System.currentTimeMillis()));
		userDao.saveUser(user);
	}

	@Override
	public User Login(User user) {
		return userDao.Login(user);
	}

	@Override
	public boolean revisePwd(User user) {
		return userDao.revisePwd(user);
	}

	@Override
	public User findUserById(Integer uid) {
		return userDao.findUserById(uid);
	}

	
}

package cn.qblank.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.qblank.admin.dao.IAdminUserDao;
import cn.qblank.admin.entity.LoginRecord;
import cn.qblank.admin.service.IAdminService;
import cn.qblank.user.entity.User;

@Service
public class AdminServiceImpl implements IAdminService {
	
	@Resource
	private IAdminUserDao adminUserDao;

	@Override
	public List<User> findAllByAuthority(Integer authority) {
		return adminUserDao.findAllByAuthority(authority);
	}

	@Override
	public void deleteUserById(Integer uid) {
		adminUserDao.deleteUserById(uid);
	}

	@Override
	public void updateUser(User user) {
		adminUserDao.updateUser(user);
	}

	@Override
	public void addUser(User user) {
		adminUserDao.addUser(user);
	}

	@Override
	public void insertLoginRecord(LoginRecord record) {
		adminUserDao.insertLoginRecord(record);
	}

	@Override
	public List<LoginRecord> findAllRecordByUser(User user) {
		return adminUserDao.findAllRecordByUser(user);
	}

}

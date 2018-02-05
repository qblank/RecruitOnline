package cn.qblank.user.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.qblank.user.dao.IUserDao;
import cn.qblank.user.entity.User;

@Repository
public class UserDaoimpl implements IUserDao{
	private HibernateTemplate template;
	
	@Autowired
	public UserDaoimpl(SessionFactory sessionFactory) {
		this.template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void saveUser(User user) {
		template.save(user);
		System.out.println("保存数据");
	}
	
}

package cn.qblank.user.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.user.dao.IUserDao;
import cn.qblank.user.entity.User;

@Repository
public class UserDaoimpl  implements IUserDao{
	private HibernateTemplate template;
	@Autowired
	public UserDaoimpl(SessionFactory sessionFactory) {
		this.template = new HibernateTemplate(sessionFactory);
	}
	
	/*@Autowired
	private IBaseDao<User> baseDao;*/
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User user) {
		template.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User Login(User user) {
		String hql = "from User where username = ? and pwd = ? and authority = ?";
//		return baseDao.get(hql, new Object[]{user.getUsername(),user.getPwd()});
		Query q = sessionFactory.getCurrentSession().createQuery(hql).
				setParameter(0, user.getUsername())
				.setParameter(1, user.getPwd())
				.setParameter(2, user.getAuthority());
		List<User> list = q.list();
		User result = null;
		if (list.size() > 0) {
			result = (User) q.list().get(0);
		}
		return result;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean revisePwd(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	
}

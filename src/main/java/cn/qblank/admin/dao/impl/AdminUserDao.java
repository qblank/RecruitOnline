package cn.qblank.admin.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.admin.dao.IAdminUserDao;
import cn.qblank.admin.entity.LoginRecord;
import cn.qblank.user.entity.User;

@Repository
@Transactional
public class AdminUserDao implements IAdminUserDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllByAuthority(Integer authority) {
		Query q = sessionFactory.getCurrentSession().createQuery("from User where authority != ?")
				.setParameter(0, authority);
		List<User> list = q.list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void deleteUserById(Integer uid) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, uid);
		if (user != null) {
			session.delete(user);
		}
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void insertLoginRecord(LoginRecord record) {
		sessionFactory.getCurrentSession().save(record);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginRecord> findAllRecordByUser(User user) {
		Query q = sessionFactory.getCurrentSession().createQuery("from LoginRecord where uid = ?").setParameter(0, user.getId());
		if (q.list().size() > 0) {
			List<LoginRecord> records = q.list();
			return records;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String lastLoginTime() {
		String hql = "from LoginRecord order by id desc";
		List<LoginRecord> loginRecords = sessionFactory.getCurrentSession().createQuery(hql).list();
		if (loginRecords != null && loginRecords.size() > 0) {
			return loginRecords.get(0).getLoginTime();
		}
		return null;
	}

}

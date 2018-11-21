package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserDao {

	static ConnectionUtil util = ConnectionUtil.getInstance();

	public User save(User u) {
		Session session = util.getSession();
		try {
			Transaction tx = session.beginTransaction();
			int id = (int) session.save(u);
			tx.commit();
			u.setId(id);
		}
		finally {
			session.close();
		}
		return u;
	}

}

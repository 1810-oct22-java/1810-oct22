package com.ex.dao;

import org.hibernate.Session;

import com.ex.models.User;
import com.ex.util.ConnectionUtil;

public class UserDao {
	
	static ConnectionUtil util = ConnectionUtil.getInstance();
	
	public User save(User u) {
		Session session = util.getSession();
		int id = (int) session.save(u);
		u.setId(id);
		return u;
	}

}

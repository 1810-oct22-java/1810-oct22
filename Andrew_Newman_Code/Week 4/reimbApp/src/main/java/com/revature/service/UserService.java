package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.pojos.User;

public class UserService {
	
	public static UserDAO uDao = new UserDAO();
	
	public User getUser(int id) {
		return uDao.findById(id);
	}
	
	public  User getUserbyUsername(String username) {
		return uDao.findByUsername(username); 
	}
	
	public User insertUser(String fn, String ln, String un, String pw, String em, int role) {
		User u = new User(un,pw,fn,ln,em,role);
		return uDao.save(u);
	}

	public String getRole(User r) {
		return uDao.findRole(r.getRoleID());
	}
	
	public User validateCreds(String un, String pw) {
		return uDao.checkPw(un,pw);
	}
}

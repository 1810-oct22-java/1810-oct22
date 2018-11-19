package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.pojos.User;

public class UserService {
	
	static UserDao uDao = new UserDao();
	
	public static void main(String[] args) {
		User user = uDao.findByUsername("employee");
		System.out.println(user);
	}

}

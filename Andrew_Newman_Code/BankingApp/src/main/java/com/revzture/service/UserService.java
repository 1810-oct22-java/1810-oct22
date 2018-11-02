package com.revzture.service;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.UserDAO;
import com.revature.pojos.User;

public class UserService {

	public static DAO<User,Integer> uDao = new UserDAO();
	
	public List<User> getAllUsers(){
		List<User> users = uDao.findAll();
		if(users.isEmpty()) return null;
		
		return users;
	}
}

package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.pojos.User;

public class UserService {

	public static UserDAO uDao = new UserDAO();
	
	public List<User> getAllUsers(){
		List<User> users = uDao.findAll();
		if(users.isEmpty()) return null;
		
		return users;
	}
	
	public void insertUser(String fn, String ln, String un, String pw){
		User newUser = new User(fn,ln,un,pw);
		uDao.save(newUser);
	}
	
	public int getId(String un) {
		return(uDao.findIdByUsername(un));
	}
	
	public String getPassword(String un){;
		return(uDao.findById(getId(un)).getPassword());
	}
}

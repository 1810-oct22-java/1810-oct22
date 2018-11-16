package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.UserDao;

import com.revature.pojo.Users;


public class UserService {
	
	static Dao<Users, Integer> userDao = new UserDao();
	
	public List<Users> getAllUsers(){
		List<Users> users = userDao.findAll();
		if(users.size() ==0 ) return null;
		return users;
	}
	
	
	public Users getByUsername(String name) {
		List<Users> users = getAllUsers();
		//could do enhanced for loop...
		if(users == null) {
			return null;
		}
		for(Users u: users) {
			if(u.getUsername().equals(name)) return u;
		}	
		return  null;
	}
	
	public Users validiateUser(String name, String password) {
		Users u = getByUsername(name);
		if(u == null) return null;
		else if(u.getPassword().equals(password)) return u; //only case where user is logged in
		else {
			return null;
		}
	}
	
	
	public Users validiateNewUser(String name) throws NullPointerException {
		Users u = new Users();
		u.setUsername(name);
		System.out.println(u);
		System.out.println(u.getUsername());
		boolean b = isUnique(u.getUsername());
		if(b) {
			return u;
		}
		else {
			return null;
		}
	
		
		
	}

	
	public Users addUser(String username, String password, String firstName, 
			String lastName, String email, int roleId) {
		if(username == null) return null;
		else return userDao.save(new Users(username, password, firstName, lastName,
				email, roleId));
	}

	public boolean isUnique(String name) throws NullPointerException {
		List<Users> users = userDao.findAll();
		System.out.println("isUnique: " + name);
		if(users == null) {
			return true;
		}
		for(Users u : users ) {
			if(name.equals(u.getUsername())) {
				return false;
			}
		}
		return true;
			
	}
	
	public Users getThatUser(String name) {
		Users u = new Users();
		u.setUsername(name);
		System.out.println(u.getUsername());
		return u;
	}
	


}

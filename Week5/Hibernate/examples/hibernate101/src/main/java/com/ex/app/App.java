package com.ex.app;

import java.util.List;

import com.ex.dao.UserDao;
import com.ex.models.User;

public class App {

	static Userdao 

	public static void main(String[] args) {
	UserDao dao = new UserDao();
//		SAVING USERS
	
//		User u1 = new User("username", "password", "firstname", "lastname");
//		User u2 = new User("gb123", "123", "Gen", "Bonds");
//		User u3 = new User("testuser", "abc", "Test", "User");
//		
//		dao.save(u1);
//		dao.save(u2);
//		dao.save(u3);
	
// 		RETRIEVING USERS
//		System.out.println("Retrieving user of id 50 with GET");
//		User u50 = dao.getById(50);
//		System.out.println("ABOUT TO TO STRING WITH GET");
//		System.out.println(u50.toString());
//
//		
//		System.out.println("Retrieving user of id 7 with LOAD");
//		User u50load = dao.loadById(7);
		
	User u = dao.findByUsername("ter");
	System.out.println(u);
	
	System.out.println("FINDING ALL");
	List<User> users = dao.findAll();
	for(User user : users) {
		System.out.println(user);
	}
	
	}

}

package com.ex.app;

import com.ex.dao.UserDao;
import com.ex.models.User;

public class Main {

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
		User u1 = new User("username", "password", "firstname", "lastname");
		User u2 = new User("gb123", "123", "Gen", "Bonds");
		User u3 = new User("testuser", "abc", "Test", "User");
		
		dao.save(u1);
		dao.save(u2);
		dao.save(u3);
	}

}

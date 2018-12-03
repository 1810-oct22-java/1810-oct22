package com.ex.app;

import java.util.List;

import com.ex.dao.PostDao;
import com.ex.dao.UserDao;
import com.ex.models.Post;
import com.ex.models.User;

public class App {

	static UserDao dao = new UserDao();
	static PostDao postDao = new PostDao();
	
	public static void main(String[] args) {
		
		User u = new User("phil", "123", "fn", "ln");
		User u1 = new User("ted", "f", "f", "f");
		u.getFollowing().add(u1);
		dao.save(u1);
		dao.save(u);
	}
	
	static void testingMultiplicity() {
		User u = new User("post", "post", "post", "post");
		Post p = new Post("subject", "body", u);
		p = postDao.save(p);
		System.out.println(p);
	}
	
	static void addPostToUser(int userId, String subject, String body) {
		User u = dao.getById(userId);
		Post p = new Post(subject, body, u);
		postDao.save(p);
		
	}

	static void testingRead() {

		System.out.println("Retrieving user of id 50 with GET");
		User u50 = dao.getById(50);
		System.out.println("ABOUT TO TO STRING WITH GET");
		System.out.println(u50.toString());


		System.out.println("Retrieving user of id 7 with LOAD");
		User u50load = dao.loadById(7);

		User u = dao.findByUsername("ter");
		System.out.println(u);

		System.out.println("FINDING ALL");
		List<User> users = dao.findAll();
		for(User user : users) {
			System.out.println(user);
		}
	}

	static void testingCreate(){

		User u1 = new User("username", "password", "firstname", "lastname");
		User u2 = new User("gb123", "123", "Gen", "Bonds");
		User u3 = new User("testuser", "abc", "Test", "User");

		dao.save(u1);
		dao.save(u2);
		dao.save(u3);
	}
}



package com.ex.app;

import java.util.List;

import com.ex.dao.PostDao;
import com.ex.dao.UserDao;
import com.ex.models.Post;
import com.ex.models.User;

public class App {
	
	static UserDao dao = new UserDao();
	static PostDao pDao = new PostDao();
	
	public static void main(String[] args) {
	
		addPostToUser(50,"Hibernate is Awesome","Today I learned about Hibernate and I liked it");
	}
	
	static void testingMultiplicity() {
		User u = new User("post","post","post","post");
		Post p = new Post("subject","body",u);
		p = pDao.save(p);
	}
	
	static void addPostToUser(int id, String subject, String body) {
		User u = dao.getById(id);
		Post p = new Post(subject,body,u);
		pDao.save(p);
	}
	
	static void testingRead() {
		//RETRIEVING USERS
		System.out.println("Retrieving User of Id 50 with GET");
		User u50 = dao.getById(50);
		System.out.println("ABOUT TO toString() WITH GET");
		System.out.println(u50.toString());
		
		System.out.println("Retrieving User of Id 50 with LOAD");
		User u50load = dao.loadById(50);
		System.out.println("ABOUT TO toString() WITH LOAD");
		String a = u50load.toString();
		System.out.println(a);
		
		User u = dao.findByUsername("testuser");
		System.out.println(u);
		
		List<User> users = dao.findAll();
		for (User usr : users) {
			System.out.println(usr);
		}
	}
	
	static void testingSaves() {
		User u1 = new User("username","password","firstname","lastname");
		User u2 = new User("tairey","pass","Ted","Airey");
		User u3 = new User("testuser","abc","test","user");
		
		dao.save(u1);
		dao.save(u2);
		dao.save(u3);
	}

}

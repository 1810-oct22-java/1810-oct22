package com.revature.main;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.UserDAO;
import com.revature.pojos.User;

public class app {

	public static void main(String[] args) {
		
		DAO<User,Integer> uDao = new UserDAO();
		
		
		//uDao.save(new User("Michael","young","Myoung","pass"));
		
		List<User> users = uDao.findAll();
		
		for(User u : users) {
			System.out.println(u);
		}
		
		
		/*DAO<Author,Integer> aDao = new AuthorDAO();
		List<Author> authors = aDao.findAll();
		for(Author a : authors) {
			System.out.println(a);
		}*/
	}
}

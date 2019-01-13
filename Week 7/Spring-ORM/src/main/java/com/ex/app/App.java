 package com.ex.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.User;
import com.ex.repository.UserRepository;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
		List<User> users = repo.getAllUsers();
		
		//for(User u : users) {
			System.out.println(users);
		//}
	}

}

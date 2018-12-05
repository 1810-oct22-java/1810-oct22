package com.ex.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ex.beans.User;
import com.ex.repository.UserRepository;

@Component
public class App {

	@Autowired
	private static UserRepository repo;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
		List<User> u = repo.oddQuery();
		System.out.println(u);
		
	}

}

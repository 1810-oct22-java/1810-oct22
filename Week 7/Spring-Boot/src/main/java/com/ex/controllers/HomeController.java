package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.User;
import com.ex.repository.UserRepository;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@RequestMapping("/")
	public String helloWorld() {
		return "Welcome to Spring Boot!";
	}

}

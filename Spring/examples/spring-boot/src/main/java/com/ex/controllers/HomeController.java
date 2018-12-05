package com.ex.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String helloWorld() {
		return "Welcome to Spring Boot!";
	}

}

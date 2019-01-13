package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
public class DemoApplication {

	private static List<String> heros = new ArrayList<String>();
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@RequestMapping("/")
//	public List<String> getPeople() {
//		List<String> list = new ArrayList<String>();
//		list.add("Newman");
//		list.add("Ted");
//		return list;
//	}
	
	public List<String> getHeroes() {
		return heros;
	}
	
	public void addHero(String name) {
		heros.add(name);
	}
}

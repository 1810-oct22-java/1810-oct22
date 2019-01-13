package com.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class UserApplication {
	
	@Autowired
	public DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	
	@RequestMapping("/")
	public List<String> getName() {
		return discoveryClient.getServices();
	}
}

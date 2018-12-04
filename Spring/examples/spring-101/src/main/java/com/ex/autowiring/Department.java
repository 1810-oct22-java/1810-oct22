package com.ex.autowiring;

import org.springframework.stereotype.Component;

@Component //Springs basic annotation to register a class as a bean
public class Department {

	private String name;

	public Department() {}

	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

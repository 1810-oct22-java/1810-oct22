package com.ex.hellospring;

public class HelloWorld {
	/*
	 * For "POJO"s to be configured as spring beans 
	 * always have public getters and setters and a no args constructor 
	 */
	
	private String message;
	
	public HelloWorld() {}

	public HelloWorld(String message) {
		System.out.println("USING CONSTRUCTOR INJECTION");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("USING SETTER INJECTION");
		this.message = message;
	}	

}
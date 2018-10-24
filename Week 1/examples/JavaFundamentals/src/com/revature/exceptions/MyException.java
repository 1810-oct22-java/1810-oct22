package com.revature.exceptions;

public class MyException extends Exception{
	
	public MyException() {
		super("This is a custom exception!");
	}
	
	public MyException(String message) {
		super(message);
	}

}

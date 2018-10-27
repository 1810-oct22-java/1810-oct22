package com.revature.classbasics;

import java.time.LocalDateTime;

public class Blocks {
	
	//instance var initialized in block
	LocalDateTime time;
	
	static {
		System.out.println("IN STATIC BLOCK BEFORE MAIN");
	}
	
	{
		System.out.println("IN NON-STATIC BLOCK BEFORE MAIN");
		time = LocalDateTime.now();
	}
	
	public static void main(String[] args) {
		System.out.println("IN MAIN METHOD");
		Blocks b = new Blocks();
		System.out.println(b.time);
	}
	
	static {
		System.out.println("IN STATIC BLOCK AFTER MAIN");
	}
	
	{
		System.out.println("IN NON STATIC BLOCK AFTER MAIN");
	}

}

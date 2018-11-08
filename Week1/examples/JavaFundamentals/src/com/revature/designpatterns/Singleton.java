package com.revature.designpatterns;

public class Singleton {
	/*
	 * The Singleton design pattern is a pattern which creates
	 * an object in memory only once throughout the lifetime of 
	 * the application to be shared across multiple classes
	 * 
	 * To make a Singleton you must make a private static variable
	 * of the class's type, make a private constructor, and make a 
	 * public static getInstance() method, which will return the single
	 * instance of the class created.
	 * 
	 * There are two types of singletons. 
	 * Lazy Singleton
	 * Eager Singleton
	 */
	
	private static Singleton singleton = new Singleton();
	private String name; //instance var to demonstrate single instance
	
	private Singleton() {
		System.out.println("instantiating eager singleton");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void test() {
		System.out.println("in eager singleton");
	}
}

//Lazily instantiate single instance of this class
class LazySingleton{
	
	//JUST declaration, NOT instantiation
	private static LazySingleton instance;
	
	private LazySingleton() {
		System.out.println("Lazily instantiating singleton");
	}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
	public static void test() {
		System.out.println("in lazy singleton class");
	}
}


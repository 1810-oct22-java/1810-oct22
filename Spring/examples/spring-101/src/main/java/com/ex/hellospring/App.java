package com.ex.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	
/*
	public static void main(String[] args) {
	//simple property dependency injection
	
		//does NOT use Spring! Remember, if you see a "new" keyword, something's typically wrong
//		HelloWorld hello = new HelloWorld();
//		System.out.println(hello.getMessage());
		
		//Intro to Spring's ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//no longer need to use "new" as we rely on the App Context to create our bean
		HelloWorld world = (HelloWorld) context.getBean("thisIsABean"); 
		System.out.println(world.getMessage());
		
		world.setMessage("changing my instance variable value here");
		
		HelloWorld world2 = (HelloWorld) context.getBean("thisIsABean"); 
		System.out.println("World's message: " + world.getMessage());
		System.out.println("World2's message: " + world2.getMessage());
		//without changing the scope of our beans, each reference to the bean will give the same object as it is singelton scope 
		
	} */
	
	
	public static void main(String[] args) {
		//exploring bean wiring
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ParentBean bean = (ParentBean) context.getBean("superBean");
		System.out.println(bean.getHello().getMessage());
	}

}

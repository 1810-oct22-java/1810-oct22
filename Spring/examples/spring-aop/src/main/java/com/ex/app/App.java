package com.ex.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.first.First;
import com.ex.second.Second;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("beans.xml");
		
		First first = (First) context.getBean(First.class);
		Second second = (Second) context.getBean(Second.class);
		System.out.println("CALLING METHOD from first");
		first.counter(10);
		
		System.out.println("Calling set method from second");
		second.setA(1);
	}

}

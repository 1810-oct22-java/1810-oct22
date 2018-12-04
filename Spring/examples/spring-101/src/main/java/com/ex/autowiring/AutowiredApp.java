package com.ex.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee e1 = (Employee) context.getBean("employee");
		e1.getDepartment().setName("Training");
		e1.setName("Genesis Bonds");
		e1.setSalary(10000000);
		
		
		Employee e2 = (Employee) context.getBean("employee");
		e2.getDepartment().setName("HR");
		e2.setName("Palmer C");
		e2.setSalary(500000000);
		
		System.out.println(e1);
		System.out.println(e2);
		
	}

}

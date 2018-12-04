package com.ex.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp{

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee e1 = (Employee) context.getBean("employee");
        e1.getDepartment().setName("Training");
        e1.setName("Genisis Bonds");
        e1.setSalary(100000000);
    }
}
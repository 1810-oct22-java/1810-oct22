package com.revature.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompareEmployee {

	public static void main(String[] args) {
		//creates 2 instances of Employee
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		//Instantiates a List of Employee as ArrayList
		List<Employee> employees = new ArrayList<>();
		
		
		//allows user input
		Scanner in = new Scanner(System.in);
		
		//user enters name of 1st employee
		System.out.println("Enter name of 1st employee");
		String name1 = in.next();
		e1.setName(name1);
		
		//user enters department of 1st employee
		System.out.println("Enter department of 1st employee");
		String department1 = in.next();
		e1.setDepartment(department1);
		
		//user enters age of 1st employee
		System.out.println("Enter age of 1st employee");
		int age1 = in.nextInt();
		e1.setAge(age1);
				
		//user enters name of 2nd employee
		System.out.println("Enter name of 2nd employee");
		String name2 = in.next();
		e2.setName(name2);
		
		//user enters department of 2nd employee
		System.out.println("Enter department of 2nd employee");
		String department2 = in.next();
		e2.setDepartment(department2);
		
		//user enters age of 2nd employee
		System.out.println("Enter age of 2nd employee");
		int age2 = in.nextInt();
		e2.setAge(age2);
		
		//adds Employees to List
		employees.add(e1);
		employees.add(e2);
		
		//sorts the list by name, department, and age
		Collections.sort(employees, new EmployeeComparator());
		
		//loops through list and prints
		for(Employee employ : employees) {
			System.out.println(employ.toString());
		}
	}

}



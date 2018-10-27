package com.revature.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question7 {
	
	public static void main(String[] args) {
		Employee em1 = new Employee("Ted", "Trainee", 22);
		Employee em2 = new Employee("Fred", "Blamee", 23);
		ArrayList<Employee> arr = new ArrayList<Employee>();
		arr.add(em1);
		arr.add(em2);
		
		//first sort by Name
		Collections.sort(arr, new sortName());
		System.out.println(arr);
		
		//then by age -> youngest first
		Collections.sort(arr, new sortAge());
		System.out.println(arr);
		
		//then by department
		Collections.sort(arr, new sortDepartment());
		System.out.println(arr);
	}

}

class sortName implements Comparator<Employee> {
	
	public int compare(Employee em1, Employee em2) {
		int sorted = em1.getName().compareTo(em2.getName());
		return sorted;
	}
}

class sortDepartment implements Comparator<Employee> {
	
	public int compare(Employee em1, Employee em2) {
		int sorted = em1.getDepartment().compareTo(em2.getDepartment());
		return sorted;
	}
}

class sortAge implements Comparator<Employee> {
	
	public int compare(Employee em1, Employee em2) {
		int sorted = em1.getAge()-em2.getAge();
		return sorted;
	}
}

class Employee {
	private String name;
	private String department;
	private int age;
	
	public Employee (String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public String getDepartment () {
		return department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String toString() {
		return "Name: " + name + ", Department: " + department + ", Age: " + age;
	}
	
}

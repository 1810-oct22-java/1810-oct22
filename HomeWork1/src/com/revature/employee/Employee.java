package com.revature.employee;

import java.util.*;


/**
 * Sort two employees based on their name, department, and age using the Comparator interface.
 * @author thienle
 *
 */
public class Employee {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		
		emp.add(new Employee("Thien", "IT", 25));
		emp.add(new Employee("Daniel", "Service", 45));
		emp.add(new Employee("Jack", "Business", 18));
		
		
		System.out.println("Sorting by name...");
		
	
		Collections.sort(emp, new NameComparator());
		
		for(Employee e : emp) {
			
			System.out.println(e);
		}
		
		System.out.println("Sorting by department...");
		
		Collections.sort(emp, new DepartmentComparator());
		
		for(Employee e : emp) {
			
			System.out.println(e);
		}
		
		System.out.println("Sorting by age...");
		
		Collections.sort(emp, new AgeComparator());
	
		
		for(Employee e : emp) {
			
			System.out.println(e);
		}
		
	}
	
	private String name;
	private String department;
	private int age;
	
	
	
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	




	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getDepartment() {
		return department;
	}






	public void setDepartment(String department) {
		this.department = department;
	}






	public int getAge() {
		return age;
	}






	public void setAge(int age) {
		this.age = age;
	}






	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	

}



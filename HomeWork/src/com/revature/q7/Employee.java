package com.revature.q7;

public class Employee {
	//fields
	private String name;
	private String department;
	private int age;
	
	//Employee constructor
	public Employee() {
		
	}

	//getters and setters
	
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

	//returns the string of the information of Employee instance
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	

}

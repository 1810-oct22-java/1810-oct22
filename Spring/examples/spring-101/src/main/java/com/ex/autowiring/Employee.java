package com.ex.autowiring;

public class Employee {
	
	private String name;
	private double salary;
	private Department department;
	
	public Employee() {}
	
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	/*
	@Override
	public toString(){
		
	}
	*/
}

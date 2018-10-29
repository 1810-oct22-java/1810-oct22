package com.revature.q7;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Question7 {
	
	//Create Sorting Objects
	SortEmployeeByAge sortEmpAge = new SortEmployeeByAge();
	SortEmployeeByDepartment sortEmpDepartment = new SortEmployeeByDepartment();
	SortEmployeeByName sortEmpName = new SortEmployeeByName();
	
	//Init list to sort
	LinkedList<Employee> empList = new LinkedList<Employee>();
	
	Question7 (){
		System.out.println("Creating List");
		//Create LinkedList for testing
		empList.add(new Employee("Joseph Ross", "Software Engineering", 22));
		empList.add(new Employee("Andrew Walker", "Education", 23));
	}
	
	public void sortByAge() {
		Collections.sort(empList,sortEmpAge);
	}
	
	public void sortByDepartment() {
		Collections.sort(empList,sortEmpDepartment);
	}
	
	public void sortByName() {
		Collections.sort(empList,sortEmpName);
	}
	
	public void driver() {
		getEmployees();
		System.out.println();
		
		System.out.println("Sorting list By Age Ascending");
		sortByAge();
		getEmployees();
		System.out.println();
		
		System.out.println("Sorting List By Department Ascending");
		sortByDepartment();
		getEmployees();
		System.out.println();
		
		System.out.println("Sorting List By Name Ascending");
		sortByName();
		getEmployees();
		System.out.println();
	}

	public static void main(String[] args) {
		Question7 test = new Question7();
		test.driver();
	}
	
	public String getEmployees() {
		
		//Used for getting expected console output
		String result = "";
		
		
		for(int i = 0; i < empList.size(); i++) {
			System.out.println(empList.get(i).toString());
			result += empList.get(i).toString() + "\n";
		}
		return result;
	}

}

class Employee {
	
	String name;
	String department;
	int age;
	
	Employee(String name, String department, int age){
		super();
		
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		return "Employee Obj {[Name: " + this.name + "],[Department: " + this.department + "],[Age: " + this.age + "]}";
	}
}

class SortEmployeeByAge implements Comparator<Employee>
{	
	public int compare(Employee emp1, Employee emp2) {
		
		if(emp1.age > emp2.age) return 1;
		if(emp1.age < emp2.age) return -1;
		return 0;
	}
}

class SortEmployeeByDepartment implements Comparator<Employee>
{	
	public int compare(Employee emp1, Employee emp2) {
		return emp1.department.compareTo(emp2.department);
	}
}

class SortEmployeeByName implements Comparator<Employee>
{	
	public int compare(Employee emp1, Employee emp2) {
		return emp1.name.compareTo(emp2.name);
	}
}


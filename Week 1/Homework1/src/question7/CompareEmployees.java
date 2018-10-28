package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompareEmployees {

	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Ian Barney", "Training", 22));
		employees.add(new Employee("Genesis Bonds", "Teaching", 50));
		employees.add(new Employee("Ian Barney", "Sales", 30));
		employees.add(new Employee("Ian Barney", "Training", 21));
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).toString());
		}
		
		Collections.sort(employees, new SortEmployee());
		
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).toString());
		}
	}

}

class Employee {

	String name;
	String department;
	int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

}

class SortEmployee implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		int value1 = 0;
		int value2 = 0;
		int value3 = 0;
		value1 = e1.name.compareTo(e2.name);
		if (value1 == 0) {
			value2 = e1.department.compareTo(e2.department);
			if (value2 == 0) {
				value3 = e1.age - e2.age;
				return value3;
			}
			return value2;
		}
		return value1;
	}

}
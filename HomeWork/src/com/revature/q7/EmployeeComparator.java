package com.revature.q7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	
	//implements the compare method, comparing by name, department, and age
	public int compare(Employee e1, Employee e2) {
		int name = e1.getName().compareTo(e2.getName());
		int department = e1.getDepartment().compareTo(e2.getDepartment());
		
		//sorts by name
		//if name is the same, then sort by department
		//if both name and department are the same, then sort by age
		if(name != 0) {
			return name;
		}
		else if(department != 0) {
			return department;
		}
		else if(e1.getAge() > e2.getAge()) {
			return 1;
		}
		else if(e1.getAge() < e2.getAge()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}

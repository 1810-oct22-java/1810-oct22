package com.revature.employee;

import java.util.*;

public class DepartmentComparator implements Comparator {
	
	public int compare(Object obj1, Object obj2) {
		
		Employee emp1 = (Employee) obj1;
		Employee emp2 = (Employee) obj2;
		
		return emp1.getDepartment().compareTo(emp2.getDepartment());
	}

}

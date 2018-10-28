package com.revature.employee;

import java.util.*;

/**
 * class implements Comparator interface to compare objects
 * @author thienle
 *
 */
public class NameComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {
		
		Employee emp1 = (Employee) obj1;
		Employee emp2 = (Employee) obj2;
		
		return emp1.getName().compareTo(emp2.getName());
	}
}

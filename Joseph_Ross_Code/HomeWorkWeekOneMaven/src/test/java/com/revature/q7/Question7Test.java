package com.revature.q7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question7Test {

	Question7 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question7();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void sortByAgeTest() {
		
		String expected = 
				"Employee Obj {[Name: Joseph Ross],[Department: Software Engineering],[Age: 22]}\n" + 
				"Employee Obj {[Name: Andrew Walker],[Department: Education],[Age: 23]}\n";
		tester.sortByAge();
		assertEquals(expected, tester.getEmployees());
	}
	
	@Test
	public void sortByDepartmentTest() {
		
		String expected = 
				"Employee Obj {[Name: Andrew Walker],[Department: Education],[Age: 23]}\n" +
				"Employee Obj {[Name: Joseph Ross],[Department: Software Engineering],[Age: 22]}\n";
		tester.sortByDepartment();
		assertEquals(expected, tester.getEmployees());
	}
	
	@Test
	public void sortByNameTest() {
		
		String expected = 
				"Employee Obj {[Name: Andrew Walker],[Department: Education],[Age: 23]}\n" +
				"Employee Obj {[Name: Joseph Ross],[Department: Software Engineering],[Age: 22]}\n";
		tester.sortByName();
		assertEquals(expected, tester.getEmployees());
	}
}
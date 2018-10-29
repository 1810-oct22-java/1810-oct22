package com.revature.q13;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question13Test {

	Question13 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question13();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void printTriangleTest() {
		
		//Testing n = 4
		String expected = 
				"0\n" + 
				"1 0\n" + 
				"1 0 1\n" + 
				"0 1 0 1\n";
		assertEquals(expected, tester.printTriangle(4));
		
		//Testing n = 1
		expected = "0\n";
		assertEquals(expected, tester.printTriangle(1));
		
		//Testing n = 0
		expected = "";
		assertEquals(expected, tester.printTriangle(0));
		
		//Testing n = negative number
		expected = "";
		assertEquals(expected, tester.printTriangle(-4));
	}
}
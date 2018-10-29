package com.revature.q10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question10Test {

	Question10 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question10();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void getMinTest() {
		
		//Normal test case
		int expected = 5;
		assertEquals(expected,tester.getMin(5,10));
		
		//Normal test case other direction
		assertEquals(expected,tester.getMin(10,5));
		
		//Negative number test case
		expected = -5;
		assertEquals(expected, tester.getMin(-2, -5));
		
		//A number is 0 case
		expected = 0;
		assertEquals(expected, tester.getMin(0, 5));
	}
}
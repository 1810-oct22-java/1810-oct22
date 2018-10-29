package com.revature.q12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question12Test {

	Question12 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question12();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void isEvenTest() {
		
		//Normal even number test
		int test = 6;
		assertTrue(tester.isEven(test));
		
		//Normal odd number test
		test = 7;
		assertFalse(tester.isEven(test));
		
		//n = 0 test
		test = 0;
		assertTrue(tester.isEven(0));
		
		//Negative even number test
		test = -6;
		assertTrue(tester.isEven(test));
		
		//Negative odd number test
		test = -7;
		assertFalse(tester.isEven(test));
	}
}
package com.revature.q2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question2Test {

	Question2 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question2();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void fibonacciTest() {
		
		//Expected result for fibonacci(25);
		String expected = 
				"0\n" + 
				"1\n" + 
				"1\n" + 
				"2\n" + 
				"3\n" + 
				"5\n" + 
				"8\n" + 
				"13\n" + 
				"21\n" + 
				"34\n" + 
				"55\n" + 
				"89\n" + 
				"144\n" + 
				"233\n" + 
				"377\n" + 
				"610\n" + 
				"987\n" + 
				"1597\n" + 
				"2584\n" + 
				"4181\n" + 
				"6765\n" + 
				"10946\n" + 
				"17711\n" + 
				"28657\n" + 
				"46368\n";
		//Testing
		assertEquals(expected, tester.fibonacci(25));
		
		//Expected result for fibonacci(1);
		expected = "0\n";
		//Testing
		assertEquals(expected, tester.fibonacci(1));
	}
}
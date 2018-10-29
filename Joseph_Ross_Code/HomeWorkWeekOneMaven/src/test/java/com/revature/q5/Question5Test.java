package com.revature.q5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question5Test {

	Question5 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question5();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void substringTest() {
		
		//Testing normal case
		String expectedOutput = "Te";
		assertEquals(expectedOutput,tester.substring("Tester", 2));
		
		//Testing case where idx is greater than the length of the string
		expectedOutput = "Tester";
		assertEquals(expectedOutput,tester.substring("Tester", 7));

		//Testing case where idx is negative
		expectedOutput = "";
		assertEquals(expectedOutput,tester.substring("Tester", -1));
		
		//Testing case where idx is 0
		expectedOutput = "";
		assertEquals(expectedOutput,tester.substring("Tester", 0));
	}
}
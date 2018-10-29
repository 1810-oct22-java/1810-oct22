package com.revature.q3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.q3.Question3;

public class Question3Test {

	Question3 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question3();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void reverseStringTest() {
		
		//Testing normal case
		String expectedOutput = "em esreveR";
		assertEquals(expectedOutput, tester.reverseString("Reverse me"));

		//Testing empty case
		expectedOutput = "";
		assertEquals(expectedOutput, tester.reverseString(""));
	}
}
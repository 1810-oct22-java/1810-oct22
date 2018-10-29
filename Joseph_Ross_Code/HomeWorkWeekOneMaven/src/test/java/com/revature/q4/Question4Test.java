package com.revature.q4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.q4.Question4;

public class Question4Test {

	Question4 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question4();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void nfactorialTest() {
		
		//Testing normal case
		int expectedOutput = 120;
		assertEquals(expectedOutput, tester.nfactorial(5));
		
		//Testing negative case (method should convert nevative to positive)
		expectedOutput = 120;
		assertEquals(expectedOutput, tester.nfactorial(-5));
		
		//Testing n = 1 case
		expectedOutput = 1;
		assertEquals(expectedOutput, tester.nfactorial(1));
		
		//Testing n = 0 case
		expectedOutput = 0;
		assertEquals(expectedOutput, tester.nfactorial(0));
	}
}
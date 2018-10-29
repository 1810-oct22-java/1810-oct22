package com.revature.q6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question6Test {

	Question6 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question6();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void isEvenTest() {
		
		//Testing normal even case
		assertTrue(tester.isEven(2));
		
		//Testing normal odd case
		assertTrue(!tester.isEven(1));
		
		//Testing n = 0 case
		assertTrue(tester.isEven(0));

		//Testing negative even case
		assertTrue(tester.isEven(-2));
		
		//Testing negative odd case
		assertTrue(!tester.isEven(-1));
		
		//Testing large even case
		assertTrue(tester.isEven(100));
		
		//Testing large odd case
		assertTrue(!tester.isEven(99));
	}
}
package com.revature.q9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question9Test {

	Question9 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question9();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void isPrimeTest() {
		
		//Testing normal prime case
		assertTrue(tester.isPrime(97));
		
		//Testing normal non prime case
		assertTrue(!tester.isPrime(98));
		
		//Testing n = 0 case
		assertFalse(tester.isPrime(0));
		
		//Testing n = 1 case
		assertTrue(!tester.isPrime(1));
		
		//Testing n is negative case
		assertTrue(!tester.isPrime(-97));
	}
}
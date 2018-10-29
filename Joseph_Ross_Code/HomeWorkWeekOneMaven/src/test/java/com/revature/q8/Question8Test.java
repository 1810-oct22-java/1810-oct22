package com.revature.q8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question8Test {

	Question8 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question8();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void isPalindromeTest() {
		
		//Testing normal false case
		String testString = "Hello";
		assertTrue(!tester.isPalindrome(testString));
		
		//Testing normal true case
		testString = "civic";
		assertTrue(tester.isPalindrome(testString));
	
		//Testing empty string case
		testString = "";
		assertTrue(tester.isPalindrome(testString));

		//Testing string with single character case
		testString = "";
		assertTrue(tester.isPalindrome(testString));
	}
}
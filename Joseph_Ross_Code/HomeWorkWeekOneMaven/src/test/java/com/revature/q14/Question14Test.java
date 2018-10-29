package com.revature.q14;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question14Test {

	Question14 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question14();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void switchStatementTest() {
		
		//Test sqrt case
		String expected = new Double(Math.sqrt(tester.numberToSquareRoot)).toString();
		assertEquals(expected, tester.switchDemo("sqrt"));
		
		//Test todays date case
		expected = new Date().toString();
		assertEquals(expected, tester.switchDemo("date"));
		
		//Test string splitting case
		String[] expectedList = {"I","am","learning","Core","Java"};
		tester.switchDemo("split");
		assertTrue(Arrays.equals(expectedList, tester.listOfWords));
	}
}
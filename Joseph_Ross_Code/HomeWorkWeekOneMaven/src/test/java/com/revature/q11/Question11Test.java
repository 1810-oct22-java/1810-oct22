package com.revature.q11;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question11Test {

	Question11 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question11();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void getFloatFromAnotherClassInDifferentPackageTest() {
		
		//Testing to make sure the values are correct
		float n1 = 5.4F;
		float n2 = 3.2F;
		assertEquals(Float.toString(n1) , Float.toString(tester.n1));
		assertEquals(Float.toString(n2) , Float.toString(tester.n2));
	}
}
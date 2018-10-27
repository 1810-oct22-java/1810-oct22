package com.revature.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.question15.Question15;

public class Question15Test {
	
	Question15 q15;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		q15 = new Question15();
	}

	@After
	public void tearDown() throws Exception {
		q15 = null;
	}

	@Test
	public void test() {
		int expectedVal = 10;
		int actualVal = q15.addition(5,5);
		assertEquals(expectedVal,actualVal);
		assertEquals(4,q15.subtraction(8,4));
		assertEquals(10,q15.multiplication(5, 2));
		assertEquals(45,q15.division(180, 4));
	}

}

package com.revature.questionfifteen;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestionFifteenTest {
	QuestionFifteen q = new QuestionFifteen();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Test");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Testing");
	}

	@After
	public void tearDown() throws Exception {
		q = null;
		System.out.println("Tearing Down");
	}

	@Test
	public void test() {
		assertEquals(10, q.additionMethod(5, 5));
	}
	
	@Test
	public void test1() {
		assertEquals(0, q.subtractionMethod(5, 5));
	}
	
	@Test
	public void test2() {
		assertEquals(25, q.multiplicationMethod(5, 5));
	}
	
	@Test
	public void test3() {
		assertEquals(1, q.divisionMethod(5, 5));
	}
	
}

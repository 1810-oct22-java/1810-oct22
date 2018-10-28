package com.revature.questionthree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestionThreeTest {
	QuestionThree q = new QuestionThree();

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

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		String s = q.stringReverse("hello");
		assertEquals("olleh", q.stringReverse("hello"));
	}

}

package com.revature.questionsix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestionSixTest {
	QuestionSix q = new QuestionSix();
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
		System.out.println("Tearing Down");
	}

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		assertEquals(true, q.evenMethod(2));
	}

}

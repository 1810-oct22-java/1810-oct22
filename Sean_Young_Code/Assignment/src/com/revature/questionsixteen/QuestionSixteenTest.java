package com.revature.questionsixteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuestionSixteenTest {
	QuestionSixteen q = new QuestionSixteen();
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
		assertEquals(5, q.characterCount("hello"));
	}

}

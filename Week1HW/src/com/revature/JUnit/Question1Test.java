package com.revature.JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.question1.Question1;

public class Question1Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int sortedarr[] = {1,2,3,4,5};
		int arr[] = {5,3,1,4,2};
		assertArrayEquals(sortedarr, Question1.bubbleSort(arr));
	}

}

package com.revature.q1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question1Test {
	
	Question1 tester;

	@Before
	public void setUp() throws Exception {
		tester = new Question1();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void testBubbleSort() {
		
		int[] originalList = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sortedList = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertTrue(Arrays.equals(sortedList, tester.bubbleSort(originalList)));
	}

}

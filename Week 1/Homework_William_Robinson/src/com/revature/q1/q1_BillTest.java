package com.revature.q1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.revature.q1.q1_Bill.bubbleSort;
class q1_BillTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	@Test
	void testMain() {
	    int[] list = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	    bubbleSort(list);
	    for (int i = 0; i < list.length; i++)
	      System.out.print(list[i] + " ");
	    /*
	     * 0 1 2 3 3 4 5 6 7 8 9 
	     * */
	}
}

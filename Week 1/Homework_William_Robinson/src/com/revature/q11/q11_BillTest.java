package com.revature.q11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.q26.q26_Bill;

class q11_BillTest {

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
	void testMain() {
		q26_Bill q26 = new q26_Bill();
		float first =  q26.frog;
		float second = q26.tadpole;
		
		System.out.println("The two float values in other package are: ");
		System.out.println(first);
		System.out.println(second);
		
		/*
		 * The two float values in other package are: 
32.134
2.23
		 * */
		
	}

}

package com.revature.q15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q15_testBillTest {

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
        int a = 25;
        int b = 5;
        q15_Bill q15 = new q15_Bill();
      int a1 =  q15.addition(a, b);
      int a2 =   q15.subtraction(a, b);
      int a3 =   q15.multiplication(a, b);
      int a4 =   q15.division(a, b);
        
        System.out.println("Result of addition: "+ a1);
        System.out.println("Result of subtraction: "+ a2);
        System.out.println("Result of multiplication: "+ a3);
        System.out.println("Result of division: "+ a4);
	
	/*
	 * Result of addition: 30
Result of subtraction: 20
Result of multiplication: 125
Result of division: 5
	 * */
	}

}

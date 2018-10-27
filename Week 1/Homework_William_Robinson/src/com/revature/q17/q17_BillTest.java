package com.revature.q17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q17_BillTest {

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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter principal amount: ");
		       float principal = scanner.nextFloat();
		System.out.println("Please enter the rate of interest");
		       float rate = scanner.nextFloat();
		System.out.println("Please enter number of years: ");
		       float time = scanner.nextFloat();
		       
		       
		   float interest = (principal * rate * time);
		   
		   System.out.println("The simple interest is: " + interest);
		   /*
		    * Please enter principal amount: 
    30000
    Please enter the rate of interest
     0.05
    Please enter number of years: 
      30
    The simple interest is: 45000.0
		    * */
	}

}

package com.revature.q4;

import static org.junit.jupiter.api.Assertions.*;
//import static com.revature.q4_Bill.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

class q4_BillTest {

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
		System.out.println("Please enter an integer to compute factorial");
		  int n = scanner.nextInt();
		
			int factorial = testFactorial(n);
			System.out.println("Factorial for " +  n + " is: " + factorial);
		
	}

	@Test
	int testFactorial(int n) {
	    if (n == 0) // Base case
		      return 1;
		    else
		      return n * testFactorial(n - 1); // Recursive call
	/*
	 * Please enter an integer to compute factorial
5
Factorial for 5 is: 120

Please enter an integer to compute factorial
3
Factorial for 3 is: 6

Please enter an integer to compute factorial
6
Factorial for 6 is: 720

	 * */
	}

}

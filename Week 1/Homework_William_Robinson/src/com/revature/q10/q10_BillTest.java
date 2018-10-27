package com.revature.q10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q10_BillTest {

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
        System.out.println("Please enter a first number of two");
         int num1 = scanner.nextInt();
        System.out.println("Please enter a first number of two");
         int num2 = scanner.nextInt();
         System.out.println("The smaller of the two numbers is ");
         testMinUsingTernary(num1, num2);
	}

	@Test
	void testMinUsingTernary(int num1, int num2) {
		int min = (num1 < num2) ? (min = num1) : (min = num2);
		System.out.print(min);
		
		/*
		 * Please enter a first number of two
34
Please enter a first number of two
53
The smaller of the two numbers is 
34

/*
 * Please enter a first number of two
789
Please enter a first number of two
1000
The smaller of the two numbers is 
789

Please enter a first number of two
345
Please enter a first number of two
039485
The smaller of the two numbers is 
345
 * */

	}

}

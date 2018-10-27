package com.revature.q6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q6_BillTest {

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
		System.out.println("Please enter an integer to determine if"
				+ " the integer is even or odd");
		int idx = scanner.nextInt();
		Integer a = new Integer(idx);
		String g = a.toBinaryString(idx);
		if(g.endsWith("1")) {
			System.out.println("Number is odd");
		}
		else {
			System.out.println("Number is even");
		}
		/*
		 * Please enter an integer to determine if the integer is even or odd
44
Number is even
Please enter an integer to determine if the integer is even or odd
67
Number is odd

		 * */
		
	}

}

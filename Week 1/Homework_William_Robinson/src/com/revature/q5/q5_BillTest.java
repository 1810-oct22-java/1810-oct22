package com.revature.q5;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q5_BillTest {

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
		System.out.println("Please enter a string: ");
		String str = scanner.nextLine();
		System.out.println("Please enter an integer to return beginning to"
				+ " last character "
				+ "of the string inclusive");
		int idx = scanner.nextInt();
		for(int i = 0; i < idx; i++) {
		System.out.print(str.charAt(i) );
		
		/*
		 * Please enter a string: 
Blah Blah BLah BLah Blah
Please enter an integer to return beginning to last character of the string inclusive
20
Blah Blah BLah BLah 
		 * */
		}
	}

}

package com.revature.q14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q14_BillTest {

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
		System.out.println("Please enter 1 2 3");
		int number = scanner.nextInt();
		
		switch(number) {
		case 1: System.out.println(Math.sqrt(number));  
		case 2: Date date = new Date(); System.out.println(date); 
		case 3: String str = new String("I am learning Core Java"); 
		String[] spl = str.split("I am learning Core Java", 1);
		for(String a:spl)
			   System.out.println(a);
			
		default:
			 if (number == 123)
				 {System.out.println(Math.sqrt(number));
			 Date date1 = new Date(); System.out.println(date1);
			 String str1 = new String("I am learning Core Java");
			 String[] spl1 = str1.split("I am learning Core Java", 1);
		for(String a:spl1)
		   System.out.println(a);
		}}
		/*
		 * 
Please enter 1 2 3
1 2 3
1.0
Sat Oct 27 01:00:36 CDT 2018
I am learning Core Java

Please enter 1 2 3
123
11.090536506409418
Sat Oct 27 01:01:25 CDT 2018
I am learning Core Java
		 * */
	}

}

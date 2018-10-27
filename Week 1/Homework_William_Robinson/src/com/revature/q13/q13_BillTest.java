package com.revature.q13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q13_BillTest {

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
	       /*
        Display the triangle on the console as 
        follows using any type of loop. Do NOT 
        use a simple group of print statements to 
        accomplish this.
0
1 0
1 0 1
0 1 0 1
        * */
		// tried different methods here
		int go = 0;
		Integer count = new Integer(4);
		StringBuilder sb = new StringBuilder();
		String s = new String();
		for (int j = 0; j< count; j++) {
			if (j % 2 == 0) {
				j = 0;
	
				
			}else if (j % 3 == 1) {
				j = 1;
		
			} else {
			}
	  if (s.contains(" 0 "+ " 0 ")){
		  s.replace(" 0 " + " 0 ", " 0 ");
	  }
	 
	  go++;
	  // Used breakpoint to pinpoint go increment
	  // and space out pyramid correctly
	  if (go == 2 || go == 4 || go ==7) {
		  System.out.println();
	  }
	  count++;
// when count is greater than 15, enough digits
	  // to build pyramid
			if (count >=15) {
				return;
			}
           System.out.print(" " + j + " ");
	/*
	 *  
 0 
 1  0 
 1  0  1 
 0  1  0  1 
	 * */
		}
	}

}

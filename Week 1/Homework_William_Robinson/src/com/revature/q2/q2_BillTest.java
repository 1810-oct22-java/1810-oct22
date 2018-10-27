package com.revature.q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q2_BillTest {

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
		int[] fibonacci = new int[25];
		for(int i = 0; i<fibonacci.length; i++) {
			  if (i ==0) {
				  fibonacci[i] = 0;
				  System.out.println(0);
			  }
			  else if (i ==1) {
				  fibonacci[i] = 1;
				  System.out.println(1);
			  }
			  else if (i==2) {
				  fibonacci[i] = 1;
				  System.out.println(1);
			  }
			  else if (i==3) {
				  fibonacci[i] = 3;
				  System.out.println(3);
			  }
			  else if (i==4) {
				  fibonacci[i] = 5;
				  System.out.println(5);
			  }
			  else {
				  
				  fibonacci[i] +=  fibonacci[i-1] + fibonacci[i-2];
			  System.out.print(fibonacci[i] + " ");
			  }
			 /*
			  * 
0
1
1
3
5
8 13 21 34 55 89 144 233 377 610 987 1597 
2584 4181 6765 10946 17711 28657 46368 75025 
			  * */
		}
	}

}

package com.revature.q12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q12_BillTest {

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
		int[] arr = new int[100];
		
		for (int i = 1; i < 101; i++) {
			arr[i-1] = i;
		}
		
		for(int a: arr) {
			
			if(a%2 ==0) {
				continue;
			} else {
				System.out.print(arr[a] + " ");
				/*2 4 6 8 10 12 14 16 18 20 22 24 26 
				28 30 32 34 36 38 40 42 44 46 48 50 
				52 54 56 58 60 62 64 66 68 70 72 74 
				76 78 80 82 84 86 88 90 92 94 96 98 100*/
			}
		}
	}

}

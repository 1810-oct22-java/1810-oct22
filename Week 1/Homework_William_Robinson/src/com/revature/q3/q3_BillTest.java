package com.revature.q3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q3_BillTest {

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
		String s = "Hello. This is a String";
		StringBuilder sb = new StringBuilder(); 
		for(int i = s.length()-1; i>= 0; i--) {
			
				sb.append(s.charAt(i));
					
		}
		System.out.println(sb);
		/*
		 * gnirts a si sihT .olleH
		 * gnirtS rehtona si a si sihT .olleH
		 * 
		 * */
	}

}

package com.revature.q6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEvenTest {
	IsEven ie;

	@Test
	void test() {
		boolean t1 = ie.isEven(4);
		boolean t2 = ie.isEven(10);
		boolean t3 = ie.isEven(5);
		boolean t4 = ie.isEven(19);
		
		assertEquals(t1, true);
		assertEquals(t2, true);
		assertEquals(t3, false);
		assertEquals(t4, false);
	}

}

package com.revature.q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {
	
	Factorial f;

	@Test
	void test() {
		int num1 = f.factorial(3);
		int num2 = f.factorial(4);
		int num3 = f.factorial(7);
		int num4 = f.factorial(10);
		assertEquals(num1, 6);
		assertEquals(num2, 24);
		assertEquals(num3, 5040);
		assertEquals(num4, 3628800);
	}

}

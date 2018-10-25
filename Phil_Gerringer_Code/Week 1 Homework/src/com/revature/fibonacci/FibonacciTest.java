package com.revature.fibonacci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {
	
	Fibonacci fib;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fib = new Fibonacci();
	}

	@AfterEach
	void tearDown() throws Exception {
		fib = null;
	}

	@Test
	void testNextNumber() {
		assertEquals(5, fib.nextNumber(2, 3));
		assertEquals(3, fib.nextNumber(3, 0));
	}

}

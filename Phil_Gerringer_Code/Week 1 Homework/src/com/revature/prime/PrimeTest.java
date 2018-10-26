package com.revature.prime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrimeTest {
	
	Prime prime;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		prime = new Prime();
	}

	@AfterEach
	void tearDown() throws Exception {
		prime = null;
	}

	@Test
	void test() {
		assertEquals(false, Prime.isPrime(1));
		assertEquals(false, Prime.isPrime(4));
		assertEquals(false, Prime.isPrime(0));
		assertEquals(true, Prime.isPrime(5));
	}

}

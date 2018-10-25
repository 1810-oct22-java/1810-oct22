package com.revature.factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest {

	Factorial fact;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fact = new Factorial();
	}

	@AfterEach
	void tearDown() throws Exception {
		fact = null;
	}

	@Test
	void test() {
		assertEquals(120, Factorial.compute(5));
		assertEquals(2, Factorial.compute(2));
	}

}

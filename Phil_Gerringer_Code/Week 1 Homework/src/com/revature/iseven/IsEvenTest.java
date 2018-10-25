package com.revature.iseven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsEvenTest {

	IsEven even;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		even = new IsEven();
	}

	@AfterEach
	void tearDown() throws Exception {
		even = null;
	}

	@Test
	void test() {
		assertEquals(false, IsEven.isEven(5));
		assertEquals(true, IsEven.isEven(2));
	}

}

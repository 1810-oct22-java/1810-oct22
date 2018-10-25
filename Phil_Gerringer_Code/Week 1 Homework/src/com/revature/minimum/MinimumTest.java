package com.revature.minimum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumTest {

	Minimum min;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		min = new Minimum();
	}

	@AfterEach
	void tearDown() throws Exception {
		min = null;
	}

	@Test
	void test() {
		assertEquals(5, Minimum.get(5, 8));
		assertEquals(5, Minimum.get(8, 5));
		assertEquals(1697, Minimum.get(1697, 27986));
	}

}

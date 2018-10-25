package com.revature.switchcase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwitchCaseTest {

	SwitchCase sc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sc = new SwitchCase();
	}

	@AfterEach
	void tearDown() throws Exception {
		sc = null;
	}

	@Test
	void testSquareRoot() {
		assertEquals(2, sc.squareRoot(4.0));
		assertEquals(1.7320508075688772, sc.squareRoot(3));
	}

	@Test
	void testDate() {
		
	}
	
	@Test
	void testSplit() {
		
	}
}

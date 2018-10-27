package com.revature.q15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q15_BillTest {

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
	int testAddition(int a, int b) {
		return a + b;
	}

	@Test
	int testSubtraction(int a, int b) {
		return a - b;
	}
	

	@Test
	int testMultiplication(int a, int b) {
		return a * b;
	}

	@Test
	int testDivision(int a, int b) {
		return a / b;
	}

}

package com.revature.lettercount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterCountTest {

	LetterCount lc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		lc = new LetterCount();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals(12, LetterCount.count("onomatopoeia"));
		assertEquals(0, LetterCount.count("     "));
	}

}

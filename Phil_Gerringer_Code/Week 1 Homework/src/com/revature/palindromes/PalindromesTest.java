package com.revature.palindromes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromesTest {
	
	Palindromes pal;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		pal = new Palindromes();
	}

	@AfterEach
	void tearDown() throws Exception {
		pal = null;
	}

	@Test
	void test() {
		assertEquals(true, Palindromes.isPalindrome("racecar"));
		assertEquals(false, Palindromes.isPalindrome("halloween"));
		assertEquals(true, Palindromes.isPalindrome("   did"));
	}

}

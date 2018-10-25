package com.revature.reversestring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseStringTest {
	
	ReverseString reverse;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		reverse = new ReverseString();
	}

	@AfterEach
	void tearDown() throws Exception {
		reverse = null;
	}

	@Test
	void test() {
		assertEquals("oob", ReverseString.reverse("boo"));
		assertEquals("did", ReverseString.reverse("did"));
		assertEquals("ped", ReverseString.reverse("dep    "));
	}

}

package com.revature.substring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubStringTest {

	SubString ss;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ss = new SubString();
	}

	@AfterEach
	void tearDown() throws Exception {
		ss = null;
	}

	@Test
	void test() {
		assertEquals("pope", SubString.substring("pope on a stick", 4));
		assertEquals("pope on ", SubString.substring("pope on a stick", 8));
	}

}

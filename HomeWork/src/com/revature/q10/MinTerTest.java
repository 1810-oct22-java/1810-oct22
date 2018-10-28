package com.revature.q10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinTerTest {
	MinTer mt;

	@Test
	void test() {
		int result1, result2;
		result1 = mt.min(3,7);
		result2 = mt.min(7,3);
		assertEquals(result1,3);
		assertEquals(result2,3);
		
	}

}

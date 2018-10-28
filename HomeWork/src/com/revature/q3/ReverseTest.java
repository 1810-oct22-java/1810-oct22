package com.revature.q3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseTest {
	Reversestring rs;

	@Test
	void test() {
		String input1 = "word";
		String reverse1 = rs.reverse(input1);
		assertEquals("drow", reverse1);
		
		String input2 = "mouse";
		String reverse2 = rs.reverse(input2);
		assertEquals("esuom", reverse2);
		
		String input3 = "machine";
		String reverse3 = rs.reverse(input3);
		assertEquals("enihcam", reverse3);
	}

}

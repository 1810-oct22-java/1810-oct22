package com.revature.q5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubstringIntTest {
	
	SubstringInt si;

	@Test
	void test() {
	String word = "string";
	String s1 = si.subStr(word, 2);
	String s2 = si.subStr(word, 3);
	String s3 = si.subStr(word, 4);
	
	assertEquals(s1, "st");
	assertEquals(s2, "str");
	assertEquals(s3, "stri");
		
	}

}

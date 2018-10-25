/**
 * 
 */
package com.revature.q18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Phil
 *
 */
class ConcreteSubClassTest {
	ConcreteSubClass c;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		c = new ConcreteSubClass();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test // of hasUpper
	void testHasUpper() {
		assertEquals(false, c.hasUpper("barbeque"));
		assertEquals(true, c.hasUpper("haPPy"));
		assertEquals(false, c.hasUpper("12345"));
	}
	
	@Test // of toUpper
	void testToUpper() {
		assertEquals("PHIL", c.toUpper("Phil"));
		assertEquals("12345", c.toUpper("12345"));
		assertEquals("BOXCAR", c.toUpper("boxcar"));
	}
	
	@Test // of add10
	void testAdd10() {
		assertEquals(20, c.add10("10"));
		assertEquals(15, c.add10("5"));
		assertEquals(0, c.add10("brak"));
	}

}

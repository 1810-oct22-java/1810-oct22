/**
 * 
 */
package com.revature.reversedstring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author thienle
 *
 */
public class ReversedStringTest {

	ReversedString r;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		r = new ReversedString();
		System.out.println("Set up instance before test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		r = null;
		System.out.println("In tear down");
	}

	@Test
	public void test() {
		
		String expectedVal = "olleH";
		String actualVal = r.reverseString("Hello");
		assertEquals(expectedVal, actualVal);
	}

}

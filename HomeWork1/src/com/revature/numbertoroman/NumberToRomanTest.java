/**
 * 
 */
package com.revature.numbertoroman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author thienle
 *Test NumberToRoman class
 */
public class NumberToRomanTest {

	NumberToRoman num;
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
		
		num = new NumberToRoman();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expectedVal = "MMXVIII";
		String actualVal = num.convertNumber(2018);
		assertEquals(expectedVal, actualVal);
	}

}

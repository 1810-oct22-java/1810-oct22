/**
 * 
 */
package com.revature.removerepeatedchar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author thienle
 *Test RemoveReapedChar
 */
public class RemoveRepeatedCharTest {

	RemoveRepeatedChar re;
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
		
		re = new RemoveRepeatedChar();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expectedVal = "afsjedrvghbA";
		String actualVal = re.removeRepeatedChar("afsjeadrffafvgdefeverhfgberAAad");
		assertEquals(expectedVal, actualVal);
	}

}

/**
 * 
 */
package com.revature.factorial;

/**
 * Test factorial
 */
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author thienle
 *
 */
public class FactorialTest {

	Factorial fac;
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
		
		fac = new Factorial();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		try {
		int actualVal = Factorial.factorial(6);
		int expectedVal = 720;
		
		assertEquals(expectedVal, actualVal);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

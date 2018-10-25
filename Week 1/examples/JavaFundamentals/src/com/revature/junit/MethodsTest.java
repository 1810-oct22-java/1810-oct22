/**
 * 
 */
package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Genesis
 * @since 10/25/2018
 *
 */
public class MethodsTest {
	
	Methods m;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new Methods();
		System.out.println("Setting up instance before test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("In tear down method");
	}

	@Test
	public void test() {
		//will call add(5, 5)
		int expectedVal = 10;
		int actualVal = m.add(5, 5);
		assertEquals("expected 10 when adding 5 and 5", expectedVal, actualVal);
		assertEquals(0, m.add());
		assertEquals(15, m.add(1, 9, 2, 3));
	}
	
	@Test
	public void anotherTest() {
		assertTrue(m.add(1)==1);
	}

}

/**
 * 
 */
package com.revature.bubblesort;

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
public class BubbleSortTest {

	BubbleSort b;
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
		
		b = new BubbleSort();
		System.out.println("setup");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		int[] a = {1,0,5,6,3,2,3,7,9,8,4};
		
		b.sort(a);
		
		int[] actualVal = a;
		int[] expectedVal = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertEquals(expectedVal, actualVal);
		
	}

}

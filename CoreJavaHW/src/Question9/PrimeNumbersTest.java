package Question9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeNumbersTest {
	
	PrimeNumbers num;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		num = new PrimeNumbers();
		
	}

	@After
	public void tearDown() throws Exception {
		
		num = null;
		
	}

	@Test
	public void test() {

		
		ArrayList<Integer> expected = new ArrayList<Integer>(
				Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97));
		
		assertEquals(expected, num.checkPrime(1, 100));
		
	}

}

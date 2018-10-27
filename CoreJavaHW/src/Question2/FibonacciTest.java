package Question2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	Fibonacci f;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		f = new Fibonacci();
		
	}

	@After
	public void tearDown() throws Exception {
		
		f = null;
		
	}

	@Test
	public void test() {
		
		ArrayList<Integer> expectedFib = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 
				610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368));
		
		assertEquals(expectedFib, f.FibonacciSeq(25));

	}
}

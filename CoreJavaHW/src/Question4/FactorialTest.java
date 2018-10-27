package Question4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {
	
	Factorial fac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		fac = new Factorial();
		
	}

	@After
	public void tearDown() throws Exception {
		
		fac = null;
		
	}

	@Test
	public void test() {
		
		int expectedVal = 3628800;
		int computedVal = fac.compute(10);
		
		assertEquals(expectedVal, computedVal);
		
	}

}

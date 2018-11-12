package Question3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseTest {
	
	Reverse r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		r = new Reverse();
		
	}

	@After
	public void tearDown() throws Exception {
		
		r = null;
		
	}

	@Test
	public void test() {
		
		String expected1 = "esrever";
		String expected2 = "racecar";
		String expected3 = "applebanana";
		
		assertEquals(expected1, r.ReverseString("reverse"));
		assertEquals(expected2, r.ReverseString("racecar"));
		assertEquals(expected3, r.ReverseString("ananabelppa"));


		
	}

}

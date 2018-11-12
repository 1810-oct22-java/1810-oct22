package Question5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubstringTest {

	Substring ss;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		ss = new Substring();
		
	}

	@After
	public void tearDown() throws Exception {
		
		ss = null;
		
	}

	@Test
	public void test() {
		
		String expectedVal = "apple";
		String computed = ss.substring("applebanana", 5);
		
		assertEquals(expectedVal, computed);

		
	}

}

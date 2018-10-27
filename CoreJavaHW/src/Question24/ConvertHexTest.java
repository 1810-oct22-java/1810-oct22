package Question24;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConvertHexTest {

	ConvertHex num;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		num = new ConvertHex();
		
	}

	@After
	public void tearDown() throws Exception {
		
		num = null;
		
	}

	@Test
	public void test() {
		
		assertEquals("1499B62", num.convertHex(21601122));
		
	}

}

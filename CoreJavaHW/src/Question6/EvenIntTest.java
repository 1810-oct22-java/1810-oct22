package Question6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvenIntTest {
	
	EvenInt ei;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		ei = new EvenInt();
		
	}

	@After
	public void tearDown() throws Exception {
		
		ei = null;
		
	}

	@Test
	public void test() {

		assertEquals(ei.isEven(22), true);
		assertEquals(ei.isEven(23), false);
		assertEquals(ei.isEven(47), false);
		assertEquals(ei.isEven(8000), true);
		
	}

}

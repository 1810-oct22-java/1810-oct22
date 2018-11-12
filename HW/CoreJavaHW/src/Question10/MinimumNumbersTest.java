package Question10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinimumNumbersTest {
	
	MinimumNumbers mn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		mn = new MinimumNumbers();
		
	}

	@After
	public void tearDown() throws Exception {
		
		mn = null;
		
	}

	//test method if minimum number is on the left
	@Test
	public void testMinLeft() {

		assertTrue(mn.findMin(10,  20) == 10);
		assertTrue(mn.findMin(120,  250) == 120);
		assertTrue(mn.findMin(300,  750) == 300);
		
	}
	
	//test method if minimum number is on the right
	@Test
	public void testMinRight() {

		assertTrue(mn.findMin(350, 70) == 70);
		assertTrue(mn.findMin(520, 145) == 145);
		assertTrue(mn.findMin(3120,  965) == 965);
		
	}

}

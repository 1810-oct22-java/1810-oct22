package Q15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InterfacesTestCase {

	Interfaces inter;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	inter = new Interfaces();
	}

	@After
	public void tearDown() throws Exception {
	inter = null;
	}

	@Test
	public void testadd() {
		assertEquals(inter.addition(4, 2),6);
	}
	
	@Test
	public void testsub() {
		assertEquals(inter.subtraction(4, 2),2);
	}
	
	@Test
	public void testdiv() {
		assertEquals(inter.division(4, 2),2);
	}
	
	@Test
	public void testmult() {
		assertEquals(inter.multiplication(4, 2),8);
	}
}

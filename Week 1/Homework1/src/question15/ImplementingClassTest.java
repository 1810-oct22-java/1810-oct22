package question15;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImplementingClassTest {

	@Test
	public void test() {
		ImplementingClass ic = new ImplementingClass();
		assertTrue(10==ic.addition(5, 5));
		assertTrue(10==ic.subtraction(20, 10));
		assertTrue(10==ic.multiplication(5, 2));
		assertTrue(10==ic.division(20, 2));
	}

}

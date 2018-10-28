package question9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeNumbersTest {

	@Test
	public void test() {
		PrimeNumbers pm = new PrimeNumbers();
		assertTrue(pm.checkPrime(7));
		assertFalse(pm.checkPrime(6));
	}

}

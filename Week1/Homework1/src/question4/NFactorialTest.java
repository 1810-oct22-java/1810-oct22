package question4;

import static org.junit.Assert.*;

import org.junit.Test;

public class NFactorialTest {

	@Test
	public void test() {
		NFactorial nf = new NFactorial();
		int checkValue = 120;
		assertTrue(checkValue == nf.factorialize(5));
	}

}

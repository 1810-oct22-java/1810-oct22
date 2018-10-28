package question6;

import static org.junit.Assert.*;

import org.junit.Test;
public class EvenOrOddTest {

	@Test
	public void test() {
		int oddNum = 7;
		int evenNum = 10;
		EvenOrOdd eoo = new EvenOrOdd();
		assertTrue(eoo.determineIfEven(evenNum));
		assertFalse(eoo.determineIfEven(oddNum));
	}

}

package question12;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenNumbersTest {

	@Test
	public void test() {
		EvenNumbers en = new EvenNumbers();
		assertTrue(en.checkEven(4));
		assertFalse(en.checkEven(3));
	}

}

package question10;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumTest {

	@Test
	public void test() {
		Minimum m = new Minimum();
		assertTrue(1==m.findMinOfTwo(1, 100));
	}

}

package question5;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringIndexTest {

	@Test
	public void test() {
		StringIndex si = new StringIndex();
		String testString = "This is a test String";
		String checkString = "This i";
		assertTrue(checkString.equals(si.getSubString(testString, 6)));
	}

}

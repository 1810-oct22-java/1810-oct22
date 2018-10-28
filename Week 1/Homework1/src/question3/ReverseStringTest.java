package question3;

import static org.junit.Assert.*;

import org.junit.Test;
public class ReverseStringTest {

	@Test
	public void test() {
		ReverseString rs = new ReverseString();
		String forwards = "Live";
		String backwards = "eviL";
		assertTrue(backwards.equals(rs.reverse(forwards)));
	}

}

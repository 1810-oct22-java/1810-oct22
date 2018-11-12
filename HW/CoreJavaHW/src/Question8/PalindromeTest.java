package Question8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalindromeTest {
	
	Palindrome str;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		str = new Palindrome();
		
	}

	@After
	public void tearDown() throws Exception {
		
		str = null;
		
	}

	@Test
	public void test() {
		
		String[] testStrings = {"karan", "madam", "tom", "civic", "radar", "sexes", 
				"jimmy", "kayak", "john", "refer", "billy", "did" };
		
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("madam", "civic", "radar", "sexes", "kayak", "refer", "did"));
		
		assertEquals(expected, str.isPalindrome(testStrings));
		
	}

}

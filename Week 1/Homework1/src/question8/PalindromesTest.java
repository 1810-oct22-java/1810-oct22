/**
 * 
 */
package question8;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Ianba
 *
 */
public class PalindromesTest {
	Palindromes p = new Palindromes();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setting up before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Tearing down after class");
	}

	@Test
	public void test() {
		assertTrue(p.checkPal("racecar"));
		assertFalse(p.checkPal("This is not a palindrome"));
	}

}

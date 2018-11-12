package Question12;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Question10.MinimumNumbers;

public class EvenNumTest {

	EvenNum num;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		num = new EvenNum();
		
	}

	@After
	public void tearDown() throws Exception {
		
		num = null;
		
	}

	@Test
	public void testEven() {
		
		//Initialize ArrayList called evenNums
		ArrayList<Integer> evenNums = new ArrayList<Integer>();
		
		//populate ArrayList with even numbers 1, 50 * 2
		for (int i = 1; i <= 50; i++) {
			
			   evenNums.add(i * 2);
			
		}
		
		//check for even numbers 1 - 100
		assertEquals(evenNums, num.printEven(1, 100));

		
		
	}


}

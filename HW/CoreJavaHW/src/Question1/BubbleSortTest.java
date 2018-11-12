package Question1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {

	BubbleSort bs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		bs = new BubbleSort();
		
	}

	@After
	public void tearDown() throws Exception {
		
		bs = null;
		
	}

	@Test
	public void test() {
		
		int [] givArr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] expArr = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};

		assertArrayEquals(bs.BubSort(givArr), expArr);
	
	}

}

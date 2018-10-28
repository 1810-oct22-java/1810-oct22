/**
 * 
 */
package question1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ianba
 *
 */
public class BubbleSortTest {

	@Test
	public void test() {
		BubbleSort bs = new BubbleSort();
		int[] unsorted = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		unsorted = bs.sortArr(unsorted);
		for(int i = 0; i < unsorted.length; i++) {
			assertTrue(unsorted[i] == sorted[i]);
		}
	}

}

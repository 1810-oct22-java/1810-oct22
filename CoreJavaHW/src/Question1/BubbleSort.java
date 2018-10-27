package Question1;

import java.util.Arrays;

public class BubbleSort {

	//Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	
	public static void main(String[] args) {
		
		//Initialize array with numbers given 
//		int[] sort = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
//		//call method on ArrayList above 
//		BubSort(sort);
		
		
	}
	
	public int[] BubSort(int[] sortArr) {
		
//		System.out.println("Before sort: " + Arrays.toString(sortArr));
		
		for(int i = 0; i < sortArr.length; i++) {
			
			for(int j = 0; j < sortArr.length - i - 1; j++) {
				
				/*
				 * Nested for loop is necessary so that for each number in the array 
				 * it will check the adjacent numbers to see if it will be swapped to
				 * the end until all numbers are sorted.
				 */
				
				//Check if numbers should be swapped
				if (sortArr[j] > sortArr[j+1]) {
					
					//Create a temporary variable to store the current element in the array
					int temp = sortArr[j];
					
					//replace current element with adjacent element (j + 1)
					sortArr[j] = sortArr[j+1];
					
					//switch the adjacent element with the temporary variable
					sortArr[j+1] = temp;
					
				}
				
			}
			
		}
		
		//print to test method
//		System.out.println("After sort: " + Arrays.toString(sortArr));

		
		return sortArr;
		
	}
	
}

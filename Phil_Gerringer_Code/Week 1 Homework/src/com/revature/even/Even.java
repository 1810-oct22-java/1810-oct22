/**
 * 
 */
package com.revature.even;

import com.revature.iseven.IsEven;

/**
 * Q12:  Write a program to store the numbers from 1 to 100 in an array.  Print out
 * 		 all of the even numbers from the array.  Use the enhanced FOR loop for printing
 * 		 out the numbers.
 * @author Phil
 *
 */
public class Even {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Even even = new Even();
		even.run();
	}
	
	/**
	 * Builds an int array and then prints out the numbers that are even
	 */
	public void run() {
		int base[] = new int[100];
		
		// populate the base 
		for(int i=1; i<=100; i++) {
			base[i-1]=i;
		}
				
		// iterate through the array and print out the evens
		for (int n: base) {
			if (IsEven.isEven(n)) {
				System.out.println(n);
			}						
		}
	}
}

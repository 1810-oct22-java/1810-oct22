/**
 * 
 */
package com.revature.even;

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
		int base[] = new int[100];
		
		// populate the base 
		for(int i=1; i<=100; i++) {
			base[i-1]=i;
		}
				
		// iterate through the array and print out the evens
		for (int n: base) {
			if (isEven(n)) {
				System.out.println(n);
			}						
		}
	}
	
	/**
	 * Return true if the number is even
	 * @param i
	 * @return
	 */
	public static boolean isEven(int i) {
		return (i%2 == 0);
	}

}

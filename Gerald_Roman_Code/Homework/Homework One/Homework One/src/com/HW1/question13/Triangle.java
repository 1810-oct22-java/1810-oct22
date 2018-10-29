package com.HW1.question13;

public class Triangle {
	/*
	 * Prints triangle 
	 * 0 
	 * 10 
	 * 010 
	 * 1010
	 * 
	 * We take the first number in the, add it to the second for loop.
	 * and check if it is modular to 2 to print either a zero or 1
	 *   
	 */
	public static void main(String[] args) {
		for (int i = 0; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				if((i + j)%2 == 0){
					System.out.print("0");
				 }else {
					 System.out.print("1");
				 }
			}
			System.out.println("\n");
		}
	}
}

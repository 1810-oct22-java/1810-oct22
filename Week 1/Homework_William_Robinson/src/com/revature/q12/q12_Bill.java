package com.revature.q12;

public class q12_Bill {

	public static void main(String[] args) {
	/*	Write a program to store numbers 
	 * from 1 to 100 in an array. Print out 
	 * all the even numbers from the array. 
	 * Use the enhanced FOR loop for printing 
	 * out the numbers.
	 */
		int[] arr = new int[100];
		
		for (int i = 1; i < 101; i++) {
			arr[i-1] = i;
		}
		
		for(int a: arr) {
			
			if(a%2 ==0) {
				continue;
			} else {
				System.out.println(arr[a]);
			}
		}
		
	}

}

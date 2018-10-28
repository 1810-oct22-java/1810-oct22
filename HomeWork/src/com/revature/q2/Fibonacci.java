package com.revature.q2;

public class Fibonacci {
	
	public static void main(String[] args) {
		int arr [] = new int [25];
		
		//sets the first 2 numbers of the pattern
		arr[0] = 0;
		arr[1] = 1;
		
		/*
		 * Starting on the 3rd element of the array, assigns
		 * each element to the sum of the 2 previous elements
		 */
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		//iterates through the array and prints
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

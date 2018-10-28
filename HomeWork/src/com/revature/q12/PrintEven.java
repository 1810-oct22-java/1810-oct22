package com.revature.q12;

public class PrintEven {

	public static void main(String[] args) {
		//creates array of size 100
		int []arr = new int[100];
		//iterates through array, adding numbers from 1 to 100
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		//loops through array and prints even numbers
		for(int i: arr) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			
		}

	}

}

package com.revature.q12;

public class Question12 {

	public static void main(String[] args) {
		
		//Create and populate integer array with integers from 1 to 100
		int[] list = new int[100];
		
		//Loop through each index in array and insert i + 1 into list[i] to get values from 1 - 100
		for(int i = 0; i < list.length; i++) 
			//Make list[i] = i + 1 because i goes from 0 - 99. Exactly one value off from what we need
			list[i] = i+1;
		
		//Enhanced for loop for getting values from list
		for(int i : list)
			if(isEven(i)) System.out.println(i);

	}
	
	public static Boolean isEven(int n) {
		
		//If n % 2 is 0 then n is even, else n must be odd
		return (n % 2 == 0) ? true : false;
	}

}

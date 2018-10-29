package com.revature.q4;

public class Question4 {

	public static void main(String[] args) {
		
		System.out.println("Calculating and printing !5");
		System.out.println(nfactorial(5));
		
	}
	
	//Note: This methods will convert n to a positive number
	public static int nfactorial(int n) {
		
		//By definition you cannot get a n factorial for a negative number
		n = Math.abs(n);
		
		//We start at n
		int result = n;
		
		//Next we loop through each int from 1 to n-1 because result starts at n
		for(int i = 1; i < n; i++) {
			
			//Multiply every int from 1 to n-1 by result
			result *= i;
		}
		return result;
	}

}

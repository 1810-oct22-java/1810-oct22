package com.revature.hw4;

public class factorial {
	public static void main(String[] args) {
		
		int i, factorial = 1, n = 5;
		
		for(i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		
		System.out.println("Factorial of " +
		n + " is " + factorial);
	}
	
	
}

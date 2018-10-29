package com.revature.q9;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		
		//Create and populate Array list with  integers from 1 to 100
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) 
			list.add(i);
		
		//Iterate through the list and print all prime numbers in list
		for(int i = 0; i < list.size(); i++)
			if(isPrime(list.get(i))) System.out.println(list.get(i));

	}
	
	// Returns true if the number is prime, false if it is not
	public static Boolean isPrime(int n) {
		
		//By definition a prime number must be greater than 1
		if(n <= 1) return false;
		
		// I start the loop at 2 to skip checking n=0 and n=1 because
		// I already checked for that condition above
		for(int i = 2; i < n; i++) {
			
			// I divide every number less than n by i and check the remainder
			// If the remainder is 0 then n has at least 3 numbers it is divisible
			// by (1, i, and itself). So by definition n cannot be prime if the
			// remainder is 0
			if(n % i == 0) return false;
		}
		
		// After we ensure that n is only divisible by 1 and itself we can say with
		// certainty this it is prime
		return true;
	}
	

}

package com.revature.q9;


public class Prime {

	public static void main(String[] args) {

		//iterates through the array of numbers
		for(int i = 1; i <= 100; i++) {
			if(isPrimeNum(i)) {
				System.out.println(i + " Is a prime number");
			}
			else {
				System.out.println(i + " Is NOT a prime number");
			}		
		}
	}
	
	//method determines whether given number is prime or not
	//if prime, returns true
	 public static boolean isPrimeNum(int n) {
	       if (n <= 1) {
	           return false;
	       }
	       for (int i = 2; i <n; i++) {
	    
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }

}

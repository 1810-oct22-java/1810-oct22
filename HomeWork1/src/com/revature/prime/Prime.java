package com.revature.prime;

import java.util.ArrayList;

/**
 * Prime number
 * @author thienle
 *
 */
public class Prime {
	
	public static void main(String[] args) {
		
		prime();
	}
	
	/**
	 * Generate number 1-100
	 */
	public static void prime() {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			al.add(i);
		}
		
		for(Integer a : al) {
			
			if(isPrime(a)) System.out.println(a);
		}
	}
	
	
	/**
	 * Check if a number is prime
	 * @param num
	 * @return
	 */
	public static boolean isPrime(int num) {
		
		int count = 0;
		
		if(num <= 1) return false;
		
		for(int i = 2; i <= num; i++) {
			if(num % i == 0) ++count;
		}
		
		if(count==1) return true;
		else return false;
		
	}

}

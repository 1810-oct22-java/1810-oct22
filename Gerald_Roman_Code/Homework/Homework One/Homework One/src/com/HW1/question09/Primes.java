package com.HW1.question09;

import java.util.ArrayList;

public class Primes {
	/*
	 * Makes a string of all the numbers between 1 to 100 If a number is not prime
	 * then it has a composite, so we create a while loop to find all the multiples
	 * and those numbers are not added to the prime array
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(FindingPrimes());
	}

	static ArrayList<Integer> FindingPrimes() {
		ArrayList<Integer> primeArr = new ArrayList<Integer>();
		boolean[] prime = new boolean[101];
		prime[1] = true;

		for (int i = 2; i <= 100; i++) {
			if (!prime[i]) {
				primeArr.add(i);
				int mult = 2;
				while (i * mult <= 101) {
					prime[i * mult] = true;
					mult++;
				}
			}
		}
		return primeArr;
	}
}
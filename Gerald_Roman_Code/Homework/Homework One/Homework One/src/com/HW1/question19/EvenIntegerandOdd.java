package com.HW1.question19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Creates the arrays to store the prime numbers, even, and odd numbers
 * It determines a number is even if it is divisible by two then puts the
 * number in an array. The array is added and the total is printed in the console
 * 
 * To find the primes, we find all the composite and return a boolean value if it is prime.
 * Then we take that list and remove the elements from the original list. Printing the remaining non Prime numbers
 * 
 */

public class EvenIntegerandOdd {
	public static void main(String[] args) {
		int[] numbers = new int[11];
		ArrayList<Integer> evenArr = new ArrayList<Integer>();
		ArrayList<Integer> oddArr = new ArrayList<Integer>();

		for (int i = 1; i < 11; i++) {
			numbers[i] = i + 1;
		}
		for (int j = 0; j < numbers.length; j++) {
			if ((numbers[j] % 2) == 0) {
				evenArr.add(j);
			} else {
				oddArr.add(j);
			}
		}

		double evenTotal = 0;
		for (int even : evenArr) {
			evenTotal += even;
		}
		double oddTotal = 0;
		for (int odd : oddArr) {
			oddTotal += odd;
		}
		Integer[] n = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(n));
		notPrimeList(list);

		System.out.println("Odd Number total: " + oddTotal + " Even Number total " + evenTotal);
		System.out.println("List with no Primes: " + list);
	}

	public static void notPrimeList(List<Integer> number) {
		for (int i = 1; i < number.size(); i++) {
			if (FindingPrimes(number.get(i))) {
				number.remove(i);
			}
		}

	}

	public static boolean FindingPrimes(int num) {
		ArrayList<Integer> primeArr = new ArrayList<Integer>();

		boolean[] prime = new boolean[11];
		prime[1] = true;

		for (int i = 2; i <= 10; i++) {
			if (!prime[i]) {
				primeArr.add(i);
				int mult = 2;
				while (i * mult <= 11) {
					prime[i * mult] = true;
					mult++;
				}
			}
		}
		return true;
	}
}

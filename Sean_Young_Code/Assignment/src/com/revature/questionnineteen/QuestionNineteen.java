package com.revature.questionnineteen;

import java.util.ArrayList;

public class QuestionNineteen {
	public static void main(String[] args) {
		/*
		 * declares static variables
		 */
		int length = 11;
		int length1 = 10;
		int sum = 0;
		int sum1 = 0;
		int num = 0;
		ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();
		for (int i = 1; i < length; i++) {
			arrayOfNumbers.add(i); //adds numbers 1 through ten to arrayOfNumbers
		}
		System.out.println(arrayOfNumbers);
		//this for loop adds all the even numbers by adding the numbers that are divisible by two
		for (int i = 1; i < arrayOfNumbers.size(); i++) {
			int x = arrayOfNumbers.get(i);
			if (x % 2 == 0) {
				sum = sum + i;

			}

		}
		System.out.println(sum);

		// this for loop adds all the integers that are not divisible by two
		for (int i = 0; i < length1; i++) {
			int x = arrayOfNumbers.get(i);
			if (x % 2 != 0) {
				sum1 = sum1 + i;

			}
		}
		System.out.println(sum1);

		for (int i = 1; i < length; i++) {
			boolean primeNum = true;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					primeNum = false;
					break;
				}
			}

			if (primeNum) {
				System.out.print(i + " ");
			}

		}
	}
}

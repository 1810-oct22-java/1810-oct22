package com.revature.questionsix;

import java.util.Scanner;

public class QuestionSix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // creates a scanner for user input
		System.out.println("Enter a number to see if it is even");
		// takes the user input
		int n = scan.nextInt();
		System.out.println(evenMethod(n));
		// takes the number that was inputed by the user and divides it by 2 and stores
		// this value within the memory
		// of number
		// if number divided by two equals the original number given by the user it is
		// even
	}

	public static boolean evenMethod(int n) {
		int number = n;
		// takes the number that was inputed by the user and divides it by 2 and stores
		// this value within the memory
		// of number
		number = n / 2;
		// if number divided by two equals the original number given by the user it is
		// even
		if (number * 2 == n) {
			return true;
		} else {
			return false;
		}
	}
}

package com.revature.questionfour;

import java.util.Scanner;

public class QuestionFour {
	public static void main(String[] args) {
		int num = 0; // declares a static variable num
		System.out.println("What number would you like to use the factorial equation for? ");
		Scanner scan = new Scanner(System.in); // takes in user input
		num = scan.nextInt(); // scans the input from the user
		factorialEquation(num); // calls method factorialEquation on the user input
	}
	
	/*
	 * This method takes a user input of type integer.  and multiplies the numbers from 1 to the number the user
	 * gave. 
	 */
	static int factorialEquation(int num2) {
		int factorial = 1;
		for(int i = 1; i <= num2; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}

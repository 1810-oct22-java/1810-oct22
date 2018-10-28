package com.revature.questionseventeen;

import java.util.Scanner;

public class QuestionSeventeen {
	public static void main(String[] args) {

		principalInterest(); // calls the method principalInterest

	}

	static void principalInterest() {
		Scanner scan = new Scanner(System.in); // creates a new scanner to take user input
		double principal = 0.0;
		double interest = 0.0;
		int years = 0;

		System.out.println("Enter the Principal: "); //asks the user to enter the principal
		// if the user input is not a number it will throw an exception and restart the method
		try {
			principal = scan.nextDouble();
		} catch (Exception e) {
			System.out.println("A number must be used!");
			principalInterest();
		}
		
		//If the user inputs a value that is not acceptable it will throw an exception

		System.out.println("Enter the Inerest Rate: ");
		try {
			interest = scan.nextDouble();
		} catch (Exception b) {
			System.out.println("A number must be used!");
			principalInterest();
		}
		// if the user inputs a value that is not acceptable it will throw an exception
		System.out.println("Enter the number of years: ");
		try {
			years = scan.nextInt();
		} catch (Exception c) {
			System.out.println("A number must be used!");
			principalInterest();
		}

		//takes all the user input and multiplies it together to return simple interest accumulated.
		double total = principal * interest * years;
		//prints out the simple interest
		System.out.println("The simple interest is: " + total);

	}
}

package com.revature.q4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		//user input
		System.out.println("Enter a number");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();

		//calls method to get the factorial of the number
		int result = factorial(input);
		System.out.println("Result: " + result);

	}
	
	//method returns the factorial of the input
	public static int factorial(int input) {
		int result = input;
		//loops through the factorials and multiplies them together
		for(int i = input - 1; i >= 1; i--) {
			result = result * i;
		}
		return result;
	}

}

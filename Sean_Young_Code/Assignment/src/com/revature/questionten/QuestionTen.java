package com.revature.questionten;

import java.util.Scanner;

public class QuestionTen {
	public static void main(String[] args) {
		minimumUsingTernary();
	}
	static void minimumUsingTernary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program will find the minimum of two numbers!"); 
		System.out.println("Enter your first number: "); // asks the user to input the first number
		int n = 0;
		int b = 0;
		try {
		n = scan.nextInt(); // takes user input
		}
		catch(Exception e) {
			System.out.println("You must enter an integer"); // if input is not an integer it throws an exception
		}
		System.out.println("Enter your next number: "); //asks user for next input
		try {
		b = scan.nextInt(); // takes the user input
		}
		catch(Exception e) {
			System.out.println("You must enter an integer!"); // if the input is not an integer it throws an exception
		}
		int num = n < b ? n : b;
		System.out.println("The minimum number is: " + num); // using ternary it finds the minimum number
	}
}

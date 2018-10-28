package com.revature.questionsixteen;

import java.util.Scanner;

public class QuestionSixteen {
	public static void main(String[] args) {
		// asks the user for a string input
		System.out.println("Enter a string to count the number of characters! \n");
		Scanner scanner = new Scanner(System.in); // creates a scanner for user input
		String s = scanner.nextLine(); // takes the user input
		System.out.println(characterCount(s)); // calls the character count function
	}

	static int characterCount(String s) {
		int character = s.length(); // turns the length of the string into an int and returns the number of
		// characters
		return character;

	}
}

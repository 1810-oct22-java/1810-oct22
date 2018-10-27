package com.revature.q16;

import java.util.Scanner;

public class q16_Bill {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String s = scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			++count;
		}
		
		System.out.println("The number of characters in string input is: " + count);
		System.out.println("The string entered was: " + sb);
		
		/*
		 Write a program to display the number 
		 of characters for a string input. 
		 The string should be entered as a 
		 command line argument using 
		 (String [ ] args).
		  */

	}

}

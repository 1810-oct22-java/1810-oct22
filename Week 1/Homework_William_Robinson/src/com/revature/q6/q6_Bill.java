package com.revature.q6;

import java.util.Scanner;

public class q6_Bill {

	public static void main(String[] args) {
		/*
		 Write a program to determine if an integer 
		 is even without using the modulus operator (%)
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an integer to determine if"
				+ " the integer is even or odd");
		int idx = scanner.nextInt();
		Integer a = new Integer(idx);
		String g = a.toBinaryString(idx);
		if(g.endsWith("1")) {
			System.out.println("Number is odd");
		}
		else {
			System.out.println("Number is even");
		}

	}

}

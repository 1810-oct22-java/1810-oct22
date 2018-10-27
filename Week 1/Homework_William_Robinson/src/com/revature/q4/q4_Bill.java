package com.revature.q4;

import java.util.Scanner;
import java.io.*;

public class q4_Bill {
	
//Write a program to compute N factorial.
// Use a recursive function
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an integer to compute factorial");
		  int n = scanner.nextInt();
		
			int factorial = factorial(n);
			System.out.println("Factorial for " +  n + " is: " + factorial);
		
	}


		  /** Return the factorial for a specified number */
		  public static int factorial(int n) {
		    if (n == 0) // Base case
		      return 1;
		    else
		      return n * factorial(n - 1); // Recursive call
		  }

}

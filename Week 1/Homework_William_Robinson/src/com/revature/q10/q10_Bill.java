package com.revature.q10;

import java.util.Scanner;

public class q10_Bill {

	public static void main(String[] args) {
	//Find the minimum of two numbers using ternary operators.
		Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a first number of two");
             int num1 = scanner.nextInt();
            System.out.println("Please enter a first number of two");
	         int num2 = scanner.nextInt();
	         System.out.println("The smaller of the two numbers is ");
	         minUsingTernary(num1, num2);
	}
	
	static void minUsingTernary(int num1, int num2) {
		      
		int min = (num1 < num2) ? (min = num1) : (min = num2);
		System.out.print(min);
	}

}

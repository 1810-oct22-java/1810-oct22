package com.revature.q10;

import java.util.Scanner;

public class MinTer {

	public static void main(String[] args) {
		
		//user input
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the 1st number");
		int num1 = in.nextInt();
		System.out.println("Enter the 2nd number");
		int num2 = in.nextInt();
		
		//call the min method and prints result
		int min = min(num1, num2);
		System.out.println(min);

	}
	
	//determines which of the 2 integers is smaller
	public static int min(int num1, int num2) {
		int min = num1 < num2 ? num1 : num2;
		return min;
	}
	

}

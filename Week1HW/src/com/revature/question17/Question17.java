package com.revature.question17;

import java.util.Scanner;

//No JUNIT as the method must take user input
public class Question17 {
	
	public static void main(String[] args) {
		double itr = interest();
		System.out.println("Your Interest = " + itr);
	}
	
	public static double interest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your principal?: ");
		double principal = Double.parseDouble(sc.nextLine());
		System.out.println("What is your interest rate (use decimal)?: ");
		double rate = Double.parseDouble(sc.nextLine());
		System.out.println("How many years have you collected interest?: ");
		double years = Double.parseDouble(sc.nextLine());
		sc.close();
		return principal*rate*years;
	}

}

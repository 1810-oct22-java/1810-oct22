package com.revature.q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		//user input
		//enters principal, rate, and time
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your principal: ");
		double p = in.nextDouble();
		System.out.println("Enter your rate: ");
		double rate = in.nextDouble();
		System.out.println("Enter your time: ");
		double time = in.nextDouble();
		
		//calculates interest
		double interest = p * rate * time;
		System.out.println("Interest is : " + interest);
	}

}

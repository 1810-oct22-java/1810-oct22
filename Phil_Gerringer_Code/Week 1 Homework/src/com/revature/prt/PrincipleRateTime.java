/**
 * 
 */
package com.revature.prt;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Q17: Write a program that calculates the simple interest on the principle,
 * 		rate of interest and number of years provided by the user.  Enter
 * 		principle, rate and time through the console using the Scanner class.  
 * 
 * @author Phil
 *
 */
public class PrincipleRateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		collectData();
	}
	
	/**
	 * ask the user for input and compute the simple interest
	 */
	public static void collectData() {
		int principle = 0;
		int rate = 0;
		int time = 0;
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("Principle: ");
			principle = scanner.nextInt();
		
			System.out.print("Rate: ");
			rate = scanner.nextInt();
		
			System.out.print("Time: ");
			time = scanner.nextInt();
			
			System.out.println("Simple Interest:  " + (principle*rate*time));
		}
		catch (InputMismatchException ims) {
			System.out.println("Invalid number! Please try again!");
			collectData();
		}
		finally {
			scanner.close();
		}
	}

}

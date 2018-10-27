package Question17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateInterest {
	
	// Q17. Write a program that calculates the simple interest on the principal,
	//	rate of interest and number of years provided by the user. Enter principal, 
	//	rate and time through the console using the Scanner class.
	//  Interest = Principal * Rate * Time

	public static void main(String[] args) {
		
		//call method
		computeInt();
		
	}

	public static double computeInt() {
		
		int principal, years;
		double rate, interest = 0.00;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the principal, rate, and time(years) respectively, separated by a space.");
		try {
			
			principal = scan.nextInt();
			rate = scan.nextDouble();
			years = scan.nextInt();
			
			interest = principal * rate * years;
			
			System.out.println("The interest is: " + interest);
			
		}
		catch (InputMismatchException e) {
			
			System.out.println("Hey! I need a number! Please try again!");
			computeInt();
			
		}
		
		return interest;
		
	}
	
}

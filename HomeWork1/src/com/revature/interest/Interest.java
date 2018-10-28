package com.revature.interest;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Calculate interest payment
 * @author thienle
 *
 */
public class Interest {
	
	public static void main(String[] args) {
		
		System.out.println("Calculate pricipal: ");
		calculatePrincipal();
	}
	
	static void calculatePrincipal() {
		
		
		
		
		try {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please enter principal: ");
			double prin = scan.nextDouble();
			
			System.out.println("Enter rate: ");
			double rate = scan.nextDouble();
			
			System.out.println("Enter number of years: ");
			double year = scan.nextDouble();
			
			System.out.println("Principal is: $" + (prin*rate*year));
		
		} 
		catch (InputMismatchException e) {
			System.out.println("Please enter correct number: ");
			
			calculatePrincipal();
		}
		

	}
	

}

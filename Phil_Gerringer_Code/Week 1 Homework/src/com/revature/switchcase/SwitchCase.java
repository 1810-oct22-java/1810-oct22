/**
 * 
 */
package com.revature.switchcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

/**
 * Q14:  Write a program demonstrating the switch case.  Implement the following
 * 		case 1:  find the square root of a number
 * 		case 2:  Display today's date
 * 		case 3:  split and put into a string array:  "I am Learning Core Java"
 * 
 * @author Phil
 *
 */
public class SwitchCase {
	public static final String LEARNING = "I am Learning Core Java";
	Scanner scanner;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int choice = 1;
		
		SwitchCase sc = new SwitchCase(new Scanner(System.in));
		
		while(choice != 0) {
			choice = sc.askChoice();
			sc.process(choice);
		}
		
		System.out.println("...done...");

	}
		
	public SwitchCase() {
		
	}
	
	/**
	 * Constructor to instantiate the scanner
	 * @param scanner
	 */
	public SwitchCase(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	/**
	 * Entrypoint for the program to ask the user their switch choice
	 * @return
	 */
	public int askChoice() {
		int choice = 4; // need a non-valid number as default
		
		try {
			System.out.print("\n1) square root, 2) date, or 3) split? ");
			choice = scanner.nextInt();
			if((choice < 0) || (choice > 3)) {
				choice = 0; // implies exit
				throw new InputMismatchException();
			}
		}
		catch (InputMismatchException ime) {
			choice = 0; // implies exit
			System.out.println("Your answer must be 1, 2, or 3. (0 exits)");
		}
		finally {
		}
		
		return choice;
	}
	
	/**
	 * process the user's input by putting it through a switch statement
	 * @param choice
	 */
	public void process(int choice) {
		switch (choice) {
		case 1:
			askSqRoot();
			break;
		case 2:
			date();
			break;
		case 3:
			split();
			break;
		}
	}
	
	/**
	 * asks the user for the number they want the square root of and then 
	 * displays the result
	 */
	public void askSqRoot() {
		double n = 0.0;
		
		try {
			System.out.print("What number do you want to know the square root of? ");
			n = scanner.nextDouble();
			System.out.println(squareRoot(n));
		}
		catch (InputMismatchException ime) {
			System.out.println("Your answer must be a number.");
		}
	}
	
	
	/**
	 * return the square root of the passed in number
	 * @param n
	 * @return
	 */
	public double squareRoot(double n) {
		return(Math.sqrt(n));
	}
	
	/**
	 * print out todays date
	 */
	public static void date() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println("Today's Date is:  " + dateFormat.format(date)); 
	}
	
	/**
	 * splits the LEARNING text and puts it into a string array
	 */
	public static void split() {
		String s = LEARNING;
		String[] parts = s.split(" ");  // parses the string pulling out the space and 
										// separating the words

		for (String str : parts) {
			System.out.println(str);
		}
	}

}

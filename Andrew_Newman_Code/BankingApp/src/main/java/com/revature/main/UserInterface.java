package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		int input = 0;
		int choice = 0;
		int tBalance = 0;
		String user;
		boolean anotherTransaction = true;
		Scanner scan = new Scanner(System.in);

		displayInitialOptions();

		while (input != 1 && input != 2) {
			if (input != 0) {
				System.out.println("Invalid selection, Please try again.");
			}

			try {
				input = scan.nextInt();
			} catch (InputMismatchException ime) {
				input = 5;
			}
			scan.nextLine();
		}

		if (input == 1) {
			user = accountCreation(scan);
		} else {
			user = logIn(scan);
		}

		while (anotherTransaction == true) {

			while (choice != 1 && choice != 2 && choice != 3) {
				if (choice != 0) {
					System.out.println("Invalid selection, Please try again.");
				}
				choice = displayTranscations(scan);
			}

			if (choice == 1) {
				tBalance = withdraw(user, scan);
			} else if (choice == 2) {
				tBalance = deposit(user, scan);
			} else {
				System.out.println("Goodbye");
				System.exit(0);
			}

			System.out.println("Your account Balance: " + tBalance);

			System.out.println("Would you like to make another transaction? (Y/N)");

			String another = "Z";

			while (!another.equals("Y") && !another.equals("N")) {
				if(!another.equals("Z")) {System.out.println("Please enter a valid response");} 
				try {
					another = scan.nextLine().toUpperCase();
				} catch (Exception e) {
				}

			}

			anotherTransaction = another.equals("Y") ? true : false;
			choice = 0;
		}

		System.out.println("Goodbye");

	}

	private static int deposit(String user, Scanner scan) {
		int totalBalance = 100;
		int amount = 0;

		System.out.println("Please enter amount to deposit: ");
		amount = scan.nextInt();
		scan.nextLine();

		totalBalance += amount;

		return totalBalance;
	}

	private static int withdraw(String user, Scanner scan) {
		int totalBalance = 100;
		int amount = 0;

		System.out.println("Please enter amount to withdraw: ");
		amount = scan.nextInt();
		scan.nextLine();

		totalBalance -= amount;

		while (totalBalance < 0) {
			totalBalance += amount;
			System.out.println("Overdraft Error, Please enter an amount below " + totalBalance);
			amount = scan.nextInt();
			scan.nextLine();

		}

		// while loop for

		return totalBalance;
	}

	private static int displayTranscations(Scanner scan) {

		System.out.println("Please choose a transaction: ");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Log Out");

		int choice;
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException ime) {
			choice = 0;
		}
		scan.nextLine();

		return choice;

	}

	private static String logIn(Scanner scan) {

		System.out.println("Log In: ");
		System.out.println("Please enter your username - ");
		String username = scan.nextLine();
		// user validation

		System.out.println("Please enter your password - ");
		String password = scan.nextLine();
		// password validation

		return username;

	}

	private static String accountCreation(Scanner scan) {

		System.out.println("Account Creation: ");
		System.out.println("Please enter a username - ");
		String username = scan.nextLine();
		// String validation
		// check uniqueness
		// store

		System.out.println("Please enter a password - ");
		String password = scan.nextLine();
		// store value

		return username;
	}

	public static void displayInitialOptions() {
		System.out.println("Generic Bank: Online banking application");
		System.out.println("Please choose an option below - ");
		System.out.println("1. Create an Account");
		System.out.println("2. Log in");

	}
}

package com.revature.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.pojos.User;
import com.revature.service.AccountService;
import com.revature.service.AccountTypeService;
import com.revature.service.UserService;

public class app {

	static UserService uService = new UserService();
	static AccountService aService = new AccountService();
	static AccountTypeService accTypeService = new AccountTypeService();

	public static void main(String[] args) {
		run();
	}

	private static void run() {

		int input = 0;
		int choice = 0;
		int accInput = 0;
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

			while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
				if (choice != 0) {
					System.out.println("Invalid selection, Please try again.");
				}
				choice = displayTranscations(scan);
			}

			if (choice == 2) {
				tBalance = withdraw(user, scan);
			} else if (choice == 3) {
				tBalance = deposit(user, scan);
			} else if (choice == 1) {
				displayAccounts(user);
				while (accInput != 1 && accInput != 2 && accInput != 3) {
					if (accInput != 0) {
						System.out.println("Invalid selection, Please try again." + "\n");
					}
					accInput = accountCreationdisplay(scan,user);
				}
				
				if(accInput == 1) {
					
				}else {
					
				}
				
			} else {
				System.out.println("Goodbye");
				System.exit(0);
			}

			System.out.println("Your account Balance: " + tBalance);

			System.out.println("Would you like to make another transaction? (Y/N)");

			String another = "Z";

			while (!another.equals("Y") && !another.equals("N")) {
				if (!another.equals("Z")) {
					System.out.println("Please enter a valid response");
				}
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
		int totalBalance = 200;
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
		System.out.println("1. Create a new account type");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Log Out");

		int choice;
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException ime) {
			choice = 0;
		}
		scan.nextLine();

		return choice;
	}

	private static void displayAccounts(String user) {

		int uid = uService.getId(user);
		System.out.println("User Accounts:  ");
		for (String s : accTypeService.convertToName(aService.createdAccounts(uid))) {
			System.out.println(s);
		}
	}

	private static int accountCreationdisplay(Scanner scan, String user) {

		int input = 0;
		int uid = uService.getId(user);
		
		System.out.println("What type of account would you like to create?");
		System.out.println("1. Checkings");
		System.out.println("2. Savings");
		System.out.println("3. Credit");

		try {
			input = scan.nextInt();
		} catch (InputMismatchException ime) {
			input = 0;
		}
		
		aService.createdAccounts(user);		

		return input;
	}

	private static String logIn(Scanner scan) {

		System.out.println("Log In: ");
		System.out.println("Please enter your username - ");
		String username = scan.nextLine();
		List<User> users = uService.getAllUsers();
		ArrayList<String> usernames = new ArrayList<String>();
		for (User u : users) {
			usernames.add(u.getUserName());
			;
		}

		if (usernames.contains(username)) {
			String storedPassword = uService.getPassword(username);
			System.out.println("Please enter your password - ");
			String password = scan.nextLine();

			if (password.equals(storedPassword)) {
				return username;
			} else {
				System.out.println("Incorrect Password, Please log in again." + "\n");
				logIn(scan);
			}
		} else {
			System.out.println("Username Does Not Exists");
			System.out.println("Please Try again" + "\n");
			logIn(scan);
		}

		// password validation

		return null;

	}

	private static String accountCreation(Scanner scan) {

		System.out.println("Account Creation: ");
		System.out.println("Please enter a username - ");
		String username = scan.nextLine();
		List<User> users = uService.getAllUsers();
		ArrayList<String> usernames = new ArrayList<String>();
		for (User u : users) {
			usernames.add(u.getUserName());
			;
		}

		if (usernames.contains(username)) {
			System.out.println("Username Already Exists");
			System.out.println("Choose a different Username" + "\n");
			accountCreation(scan);
		} else {
			System.out.println("Please enter a password - ");
			String password = scan.nextLine();
			System.out.println("Please enter your FirstName - ");
			String firstName = scan.nextLine();
			System.out.println("Please enter your LastName - ");
			String lastName = scan.nextLine();

			uService.insertUser(firstName, lastName, username, password);

			return username;
		}

		return "";
	}

	public static void displayInitialOptions() {
		System.out.println("Generic Bank: Online banking application");
		System.out.println("Please choose an option below - ");
		System.out.println("1. Create an Account");
		System.out.println("2. Log in");

	}

}

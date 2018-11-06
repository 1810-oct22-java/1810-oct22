package com.revature.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.CustomerDao;
import com.revature.db.objects.Account;
import com.revature.db.objects.Customer;
import com.revature.exception.customerdao.InvalidAccountCredentialsException;
import com.revature.exception.input.IllegalCharactersInputException;
import com.revature.exception.input.NotEnoughCharactersInputException;
import com.revature.exception.input.TooManyCharactersInputException;
import com.revature.util.InputValidation;

public class AppDriver {
	
	Customer user;
	ArrayList<Account> accounts;
	Scanner sc;
	
	public void login() {
		
		Boolean loginSuccess = false;
		
		//While a successful login has yet to be made
		while(!loginSuccess) {
		
			System.out.println("Please Enter Your Username: ");
			String username = this.sc.nextLine();
			
			try {
				InputValidation.checkStringInput(username);
				
			} catch (TooManyCharactersInputException e) {
				System.out.println("Username Invalid: Usernames must be under 11 characters");
				continue;
				
			} catch (NotEnoughCharactersInputException e) {
				System.out.println("Username Invalid: Usernames must be over 3 characters");
				continue;
				
			} catch (IllegalCharactersInputException e) {
				System.out.println("Username Invalid: Usernames can only contain numbers and letters!");
				continue;
				
			}
			
			System.out.println("Please Enter Your Password: ");
			String password = sc.nextLine();
			
			try {
				InputValidation.checkStringInput(password);
				
			} catch (TooManyCharactersInputException e) {
				System.out.println("Password Invalid: Passwords must be under 11 characters");
				continue;
				
			} catch (NotEnoughCharactersInputException e) {
				System.out.println("Password Invalid: Passwords must be over 3 characters");
				continue;
				
			} catch (IllegalCharactersInputException e) {
				System.out.println("Password Invalid: Passwords can only contain numbers and letters!");
				continue;
				
			}
			
			try {
				this.user = CustomerDao.loginAttempt(new Customer(username, password));
				loginSuccess = true;
			} catch (InvalidAccountCredentialsException e) {
				System.out.println("Username and or password is incorrect, please try again");
				
			} catch (SQLException e) {
				System.out.println("An unknown error occured, please try login in again....");
				
			}
		}
		
		System.out.println("Logged on as: " + this.user.getUsername());
		
	}
	
	public void createAccount() {
		System.out.println("::TO DO:: Cre");
	}
	
	
	public void printAccounts() {
		System.out.println("::TO DO:: Pri");
	}

	public void withdraw() {
		System.out.println("::TO DO:: With");
	}
	
	public void deposit() {
		System.out.println("::TO DO:: Depo");
	}
	
	public void transfer() {
		System.out.println("::TO DO:: Trans");
	}

	public static void main(String[] args) {
		
		AppDriver app = new AppDriver();
		
		app.sc = new Scanner(System.in);
		
		System.out.println("Welcome to Ross Credit Union!");
		
		Boolean loggedIn = false;
		
		while(!loggedIn) {
			System.out.println("What would you like to do?");
			System.out.println("Enter 1: For creating account");
			System.out.println("Enter 2: For logging into an existing account");
			
			String input = app.sc.nextLine();
			
			if(!input.replaceAll("[^1-2]", "").equals(input)) {
				System.out.println("Error Invalid Option: Please enter an option in the form of a number from 1 to 2!");
				continue;
			} else if (input.length() != 1) {
				System.out.println("Error Invalid Option: Multiple numbers detected as input. Please enter an option in the form of a number from 1 to 2!");
				continue;
			}
			
			switch(input) {
				case "1":
					app.createAccount();
					break;
				case "2":
					app.login();
					break;
				default:
					System.out.println("Error Invalid Option: Please enter an option in the form of a number from 1 to 6!");
			}
		}
		
		Boolean userIsDone = false;
		
		//While user isn't done
		while(!userIsDone) {
		
			System.out.println("What would you like to do?");
			System.out.println("Enter 1: For showing open accounts and balances");
			System.out.println("Enter 2: For creating a new account");
			System.out.println("Enter 3: For withdraw money from account");
			System.out.println("Enter 4: For depositing money from account");
			System.out.println("Enter 5: For transferring money from one account to another");
			System.out.println("Enter 6: For ending the program");
			
			String input = app.sc.nextLine();
			
			if(!input.replaceAll("[^1-6]", "").equals(input)) {
				System.out.println("Error Invalid Option: Please enter an option in the form of a number from 1 to 6!");
				continue;
			} else if (input.length() != 1) {
				System.out.println("Error Invalid Option: Multiple numbers detected as input. Please enter an option in the form of a number from 1 to 6!");
				continue;
			}
			
			switch(input) {
				case "1":
					app.printAccounts();
					break;
				case "2":
					app.createAccount();
					break;
				case "3":
					app.withdraw();
					break;
				case "4":
					app.deposit();
					break;
				case "5":
					app.transfer();
					break;
				case "6":
					userIsDone = true;
					break;
				default:
					System.out.println("Error Invalid Option: Please enter an option in the form of a number from 1 to 6!");
			}
			
			System.out.println("Thank you for banking with Ross Credit Union! Have a great day!");
			
		}
	}

}

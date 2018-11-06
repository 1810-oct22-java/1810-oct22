package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountTypeDao;
import com.revature.dao.UserDao;
import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;

public class ServiceFunctions {
	
	public static void start() {
		//SCANNER - Register or email
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		if (in.toLowerCase().equals("r") || in.toLowerCase().equals("register")) {
			newUser();
		}
		else { 
			User u = checkPassword(in);
			userFun(u);
		}
	}
	
	public static void newUser() {
		System.out.println("Welcome New User!");
		User u = new User();
		System.out.print("Enter an email: ");
		Scanner sc = new Scanner(System.in);
		String email = sc.nextLine();
		System.out.print("Enter a password: ");
		String password = sc.nextLine();
		System.out.print("What is your First Name: ");
		String fn = sc.nextLine();
		System.out.print("What is your Last Name: ");
		String ln = sc.nextLine();
		System.out.println(ln);
		u.setEmail(email);
		u.setPassword(password);
		u.setFirstName(fn);
		u.setLastName(ln);
		
		//Write to database
		UserDao uDao = new UserDao();
		uDao.insert(u);
		
		newAccount(u);
	}
	
	public static void printMenu() {
		System.out.println("##############################################################");
		System.out.println("#------------------------------------------------------------#");
		System.out.println("#| Please select an option:                                 |#");
		System.out.println("#| 1) Make a deposit                                        |#");
		System.out.println("#| 2) Withdraw funds                                        |#");
		System.out.println("#| 3) Check your balance                                    |#");
		System.out.println("#| 4) Create a new account                                  |#");
		System.out.println("#| 5) Quit Bank App                                         |#"); 
		System.out.println("#------------------------------------------------------------#");
	}
	
	public static User checkPassword(String email) {
		UserDao uDao = new UserDao();
		User u = uDao.findByEmail(email);
		Scanner sc = new Scanner(System.in);
		while (u == null) {
			System.out.println("Enter a valid email:");
			email = sc.nextLine();
			u = uDao.findByEmail(email);
		}
		System.out.println("Enter your password: ");
		String pass = sc.nextLine();
		while (pass.equals(u.getPassword()) == false) {
			System.out.println("Wrong password!");
			System.out.print("Enter again (or press q to re-enter email):");
			pass = sc.nextLine();
			if (pass.toLowerCase().equals("q")) {
				checkPassword(email);
			}
		}
		return u;
	}
	
	public static void userFun(User u) {
		Account a = new Account();
		a = findAccount(u);
		printMenu();
		Scanner sc = new Scanner(System.in);
		String opt = sc.nextLine();
		switch (opt) {
			case "1":
				deposit(a);
				break;
			case "2":
				withdraw(a);
				break;
			case "3":
				checkBalance(a);
				break;
			case "4":
				newAccount(u);
				break;
			case "5":
				System.exit(0);
			default :
				System.out.println("Not a valid input!");
				userFun(u);
		}		
	}
	
	public static Account findAccount(User u) {
		int id = u.getId();
		AccountDao aDao = new AccountDao();
		List<Account> accounts = aDao.findAll();
		Account useracts[] = new Account[3];
		System.out.println("Which account would you like?");
 		for (Account a : accounts) {
			if (a.getUserID()==id) {
				if (a.getType()==1) {
					System.out.println("1) Savings");
					useracts[0]=a;
				}
				if (a.getType()==2) {
					System.out.println("2) Checking");
					useracts[1]=a;
				}
				if (a.getType()==3) {
					System.out.println("3) Credit");
					useracts[2]=a;
				}
			}
		}
 		//Selecting account type
 		Scanner sc = new Scanner(System.in);
 		System.out.println("Or press Q to quit");
 		String opt = sc.nextLine();
 		switch (opt) {
 			case "1" :
 				if (useracts[0]==null) {
 					System.out.println("Select correct account type!");
 					findAccount(u);
 				}
 				return useracts[0];
 			case "2" :
 				if (useracts[1]==null) {
 					System.out.println("Select correct account type!");
 					findAccount(u);
 				}
 				return useracts[1];
 			case "3" :
 				if (useracts[2]==null) {
 					System.out.println("Select correct account type!");
 					findAccount(u);
 				}
 				return useracts[2];
 			case "Q" :
 				System.exit(0);
 			default :
 				System.out.println("Select correct account type!");
 				findAccount(u);
 				break;		
 		}
		return null;
	}
	
	public static void deposit (Account a) {
		System.out.println("How much money would you like to deposit?");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		while (amount <= 0) {
			System.out.println("Enter positive number!");
			amount = sc.nextDouble();
		}
		a.setBalance(a.getBalance()+amount);
		System.out.println("Success! Current Balance = " + a.getBalance());
		
		//WRITE TO DATABASE
		AccountDao aDao = new AccountDao();
		aDao.update(a);
		
		UserDao uDao = new UserDao();
		User u = uDao.findByID(a.getUserID());
		userFun(u);
	}
	
	public static void withdraw (Account a) {
		System.out.println("How much money would you like to withdraw?");
		Scanner sc = new Scanner(System.in);
		double amount = sc.nextDouble();
		while (amount <= 0) {
			System.out.println("Enter positive number!");
			amount = sc.nextDouble();
		}
		while (a.getBalance()<amount) {
			System.out.println("Not enough funds.");
			System.out.println("How much money would you like to withdraw?");
			amount = sc.nextDouble();
		}
		a.setBalance(a.getBalance()-amount);
		System.out.println("Dispensing Cash. Current Balance = " + a.getBalance());
		
		//WRITE TO DATABASE
		AccountDao aDao = new AccountDao();
		aDao.update(a);
		
		UserDao uDao = new UserDao();
		User u = uDao.findByID(a.getUserID());
		userFun(u);
	}
	
	public static void checkBalance (Account a) {
		System.out.println("Your balance is: "+a.getBalance());
		
		
		UserDao uDao = new UserDao();
		User u = uDao.findByID(a.getUserID());
		userFun(u);
	}
	
	public static void newAccount (User u) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of account would you like?");
		System.out.println("1) Savings");
		System.out.println("2) Checking");
		System.out.println("3) Credit");
		Account a = new Account();
		String type = sc.nextLine();
		switch (type) {
		case "1" :
			a.setType(1);
			break;
		case "2" :
			a.setType(2);
			break;
		case "3" :
			a.setType(3);
			break;
		default :
			System.out.println("Enter a valid option!");
			newAccount(u);
		}
		a.setBalance(0);
		a.setUserID(u.getId());
		
		//write to database insert(a)
		AccountDao aDao = new AccountDao();
		aDao.insert(a);
		
		userFun(u);
	}

}

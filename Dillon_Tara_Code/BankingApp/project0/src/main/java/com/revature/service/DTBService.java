package com.revature.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.DAO;
import com.revature.dao.UserDAO;
import com.revature.main.MyException;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class DTBService {

	public static void entryMenu() {
		System.out.println(
				"WELCOME TO DILLON TARA BANKING SERVICE!" +
				"\n-----------------------------------------------" +
				"\n Please Create an Account or Log !" +
				"\n \n 1)  Create an Account" + 
				"\n 2)  Login" + 
				"\n 3)  Exit"
				);
	
		Scanner scan = new Scanner(System.in);
			
		int opt = 0;
		
		while(opt !=3)
			try {
				opt = scan.nextInt();
				switch(opt) {
					case 1: createUser();
							break;				
					case 2: logIn();
							break;					
					case 3: System.out.println("GoodBye!"); 
							entryMenu();
							break;
					default:
							System.out.println("Please select one of the options!");
							break;
					}
				} catch(InputMismatchException e){
					System.out.println("ERROR! Please select one of above options!!");
				}
	
	}
	
	

	static void logIn() {
		UserDAO ud = new UserDAO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your username");
		String un = scan.nextLine();
		System.out.println("Enter your password");
		String pw = scan.nextLine();
		if(ud.findByUsername(un, pw) == null) {
			System.out.println("Username or password incorrect!");
			entryMenu();
		} else {
			User user = new User();
			user = ud.findByUsername(un, pw);
			accountMenu();
		}
		
	}



	static void createUser() {
		
		UserDAO ud = new UserDAO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String fn = scan.nextLine();
		System.out.println("Enter your last name: ");
		String ln = scan.nextLine();
		System.out.println("Enter a desired username: ");
		String un = scan.nextLine();
		while (existingUserName(un)) {
			System.out.println("Must Enter a Valid Email!");
			un = scan.nextLine();
		}
		
		
		System.out.println("Enter a desired password: ");
		String pw = scan.nextLine();
		
		User u = new User(fn, ln, un, pw);
		ud.save(u);
		System.out.println("NEW USER CREATED!");
		createAccount(u);
		
	}

	
	
	static void createAccount(User u) {
		System.out.println("What type of account would you like to create? " +
							"\n-----------------------------------------------" +
							"\n 1) Checking " +
							"\n 2) Saving ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		try { 
			opt = scan.nextInt();
			switch(opt) {
			case 1:
				checking(u, 0);
				accountMenu();
				break;
			case 2: 
				saving(u, 0);
				accountMenu();
				break;
			default: 
				System.out.println("Please select one of the options!");
				break;
			}
		} catch(InputMismatchException e) {
			System.out.println("ERROR! Please select one of above options!!");
			createAccount(u);
			
		}
		
		
	}

	
	private static void accountMenu() {
		System.out.println("What would you like to do? " +
				"\n-----------------------------------------------" +
						   "\n 1)  Deposit Money " +
						   "\n 2)  Withdraw Money " +
						   "\n 3)  Log Out"	);
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		try {
			switch(opt) {
			case 1: depositMoney(opt);
					break;
			case 2: withdrawMoney(opt);
					break;
			case 3: entryMenu();
					break;
			default:
				System.out.println("Please select one of the options!");
				break;
			}
			
			
		} catch(InputMismatchException e) {
			System.out.println("ERROR! Please select one of above options!!");
		}
	}

	


	private static void depositMoney(int id) {
		AccountDAO ad = new AccountDAO();
		Account a  = new Account();
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your Account ID Number?");
		for(Account ac : ad.findAll()) {
			if(ac.getUserId() == id) {
				System.out.println(ac);
			}
		}
		int acc = scan.nextInt();
		a = ad.findById(acc);
		System.out.println("How much money would you like to deposit?");
		int n = scan.nextInt();
		int balance = a.getBalance() + n;
		a.setBalance(balance);
		ad.update(a);
	}
		
		
	private static void withdrawMoney(int id) {
		AccountDAO ad = new AccountDAO();
		Account a  = new Account();
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your Account ID Number");
		for(Account ac : ad.findAll()) {
			if(ac.getUserId() == id) {
				System.out.println(ac);
			}
		}
		int acc = scan.nextInt();
		a = ad.findById(acc);
		int n = 0;
		
		System.out.println("How much money would you like to withdraw?");
		try {
			n = scan.nextInt();
			int newBalance = a.getBalance() - n;
			if(newBalance >= 0) {
				a.setBalance(newBalance);
				ad.update(a);
				
			} else {
				throw new MyException();
			}
		} catch(MyException e) {
			e.printStackTrace();
		}	
		
		
		
	}
		

	private static void checking(User u, int balance) {
		Account a = new Account(1, u.getUserid(), balance);
		AccountDAO ad = new AccountDAO();
		ad.save(a);
	}
	
	
	private static void saving(User u, int balance) {
		Account a = new Account(2, u.getUserid(), balance);
		AccountDAO ad = new AccountDAO();
		ad.save(a);
		
	}
	
	

	

	public static boolean existingUserName(String un) {
		UserDAO uDao = new UserDAO();
		List<User> users = uDao.findAll();
		for (User user : users) {
			if (user.getUserName().equals(un)) {
				return true;
			}
		} 
		return false;
	}	






}

	 
	


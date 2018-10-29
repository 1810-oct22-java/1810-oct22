package com.banking.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.banking.io.Input;
import com.banking.logging.Log;

public class ATM {
	private Logger log = Log.getInstance(this); // get an instance to the logger class
	private Scanner input = Input.getInstance();
	
	private boolean exit = false;
	private final String NEW_KEY = new String("#");  // key to enter to exit the process
	private final String EXIT_KEY = new String("@");  // key for exit
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.start();
	}
	
	/**
	 * main entry point for the class
	 */
	public void start() {
		User user;
		
		do {
			user = new User();
			
			// beginning we need to get the initial input
			user.setID(userLogin().trim());
			if(user.getID().equals(EXIT_KEY)) {
				exit=true;
				break;
			}
			
			// need to validate user is new or existant
			user = findUser(user);
			
			
			
			
			
			
			// assuming at this point we have a valid ID ask the password question
			user.setPassword(userPassword());
			
			log.debug(user.toString());
		} 
		while (!exit);
		
		log.debug("program end...");
	}
	
	/**
	 * asks the user to enter their ID or # to create a new account 
	 * Note:  an entry of '@' will exit the program
	 * 
	 * @return
	 */
	public String userLogin() {
		String choice = NEW_KEY;
		
		System.out.println(getHeader());
		System.out.println("                                 - Login\n");
		System.out.print("Enter ID (enter " + NEW_KEY + " for a new account): ");
		choice = input.nextLine();
		
		log.debug("User ID entered " + choice);
		return(choice);
	}
	
	public String userPassword() {
		String choice = NEW_KEY;
		
		System.out.print("Enter Password: ");
		choice = input.nextLine();
		
		log.debug("User Password entered " + choice);
		return(choice);
	}
	
	/**
	 * returns a formatted header for the display. - we love our bank label
	 * 
	 * @return
	 */
	public static String getHeader() {
		return("         <Welcome to ACME bank>     \n"+
		       "----------------------------------------");
	}
	
	public User findUser(User user) {
		user.setLoggedIn(true); 
		return user;
	}
}

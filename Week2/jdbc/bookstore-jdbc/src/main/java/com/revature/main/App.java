package com.revature.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		run();
	}

	static void run() {
		
		System.out.println("Hello welcome to Barne's and noble!"
				+ "What would you like to do?"
				+ "\n 1. View all books"
				+ "\n 2. View books by genre"
				+ "\n 3. View books by author"
				+ "\n 4. Add a book to the library");
		Scanner scan = new Scanner(System.in);
		int option = 0;
		try {
			option = scan.nextInt();
			switch(option) {
			case 1: viewAllBooks(); break;
			case 2: 
			case 3: 
			case 4:
			default: //means that they did not enter a number that we want
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Sorry! You must enter a number from our menu");
			run();
		}
	}

	static void viewAllBooks() {
		//consult my service layer, which will get the books from my dao
	}

}

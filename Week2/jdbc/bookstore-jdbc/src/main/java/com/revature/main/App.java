package com.revature.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.pojos.Book;
import com.revature.service.BookService;

public class App {
	static BookService bService = new BookService();

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
			default: 
				System.out.println("Please enter a number on our menu");
				run(); break;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Sorry! You must enter a number from our menu");
			run(); 
		}
	}

	static void viewAllBooks() {
		List<Book> books = bService.getAllBooks();
		if(books == null) {
			System.out.println("Our book supply is currently empty. Come back tomorrow!");
		}
		else {
			for(Book b : books) {
				System.out.println(b.getTitle());
			}
		}
	}

}

package com.revature.io;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.pojos.Person;
/*
 * ^static imports allow us to refer to static fields 
 * 	of a class without the class name
 */
public class ScannerExample {

	public static void main(String[] args) {

		//instantiate our scanner
		//without imports:
		//java.util.Scanner scanner = new java.util.Scanner(System.in);
		//runGreeting();

		System.out.println(addNums());

	}

	static int addNums() {
		//take in two numbers from user and add them together
		//add input validation
		System.out.println("Enter the numbers you would like to add, separated by a space");
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		String[] numArr = nums.split(" ");
		int total = 0;
		for(String s : numArr) {
			total += Integer.parseInt(s);
		}

		return total;
	}

	static void runGreeting() {
		Scanner scanner = new Scanner(in);

		//also utilizing static imports here
		out.println("Hello! Good Morning. What is your name?");
		String name = scanner.nextLine();
		System.out.println("What do you do for fun?");
		String hobby = scanner.nextLine();

		System.out.println("How old are you?");
		int age = 0;
		try {
			age = scanner.nextInt(); //must validate
			Person p = new Person(name, hobby, age);
			System.out.println(p); //toString();
		}
		catch(InputMismatchException e) {
			System.out.println("Hey! I need a number! Please try again!");
			runGreeting();

			//e.printStackTrace();
		}
		finally { //Finally blocks - typically used to close opened resources
			scanner.close();
		}
	}

}

package com.revature.q14;

import java.util.*;

public class q14_Bill {

	public static void main(String[] args) {
		/*
		 Write a program that demonstrates the switch case. 
		 Implement the following functionalities in the cases:
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a sting array.
       “I am learning Core Java”
		  */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 1 2 3");
		int number = scanner.nextInt();
		
		switch(number) {
		case 1: System.out.println(Math.sqrt(number));  
		case 2: Date date = new Date(); System.out.println(date); 
		case 3: String str = new String("I am learning Core Java"); 
		String[] spl = str.split("I am learning Core Java", 1);
		for(String a:spl)
			   System.out.println(a);
			
		default:
			 if (number == 123)
				 {System.out.println(Math.sqrt(number));
			 Date date1 = new Date(); System.out.println(date1);
			 String str1 = new String("I am learning Core Java");
			 String[] spl1 = str1.split("I am learning Core Java", 1);
		for(String a:spl1)
		   System.out.println(a);
		}}

	}

}

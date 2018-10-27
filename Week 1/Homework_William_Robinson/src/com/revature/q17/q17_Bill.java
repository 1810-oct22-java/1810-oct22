package com.revature.q17;

import java.util.Scanner;

public class q17_Bill {

	public static void main(String[] args) {
	   
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter principal amount: ");
	       float principal = scanner.nextFloat();
	System.out.println("Please enter the rate of interest");
	       float rate = scanner.nextFloat();
	System.out.println("Please enter number of years: ");
	       float time = scanner.nextFloat();
	       
	       
	   float interest = (principal * rate * time);
	   
	   System.out.println("The simple interest is: " + interest);
		/*
	    Write a program that calculates the 
	    simple interest on the principal, 
	    rate of interest and number of years 
	    provided by the user. Enter principal, 
	    rate and time through the console using 
	    the Scanner class.
       Interest = Principal* Rate* Time 
	    */

	}

}

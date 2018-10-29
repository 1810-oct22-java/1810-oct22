package com.revature.q14;

import java.util.Date;

public class Question14 {
	
	//Initializing non static variables to be used by object
	int numberToSquareRoot;
	String stringToBeSplit;
	String[] listOfWords;
	
	Question14 () {
		super();
		
		//Setting values of non static variables to be used by object
		this.numberToSquareRoot = 5;
		this.stringToBeSplit = "I am learning Core Java";
	}
	
	public String switchDemo(String testCase) {
		
		//This switch statement will only the given testCase
		switch(testCase) {
		
		case("sqrt"):
			
			// A new instance of the double object is made to convert the result
			// of the square root to a string that can be returned in this method
			return new Double(Math.sqrt(this.numberToSquareRoot)).toString();
		
		case("date"):
			
			//Todays date is lazily loaded just in case a day passes before method
			//is called
			return new Date().toString();
		
		case("split"):
			
			this.listOfWords = this.stringToBeSplit.split(" ");
			break;
		default:
			System.out.println("Invalid Case!");
		}
		
		return "";
	}
}

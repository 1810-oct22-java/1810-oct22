package com.revature.questioneight;

import java.util.ArrayList;

public class QuestionEight {
	public static void main(String[] args) {
		ArrayList<String> myArray = new ArrayList<String>(); //creates a new ArrayList of type String
		ArrayList<String> myArray1 = new ArrayList<String>(); // creates a new ArrayList of type String
		/*
		 * adds words to myArray
		 */
		myArray.add("karan");
		myArray.add("madam");
		myArray.add("tom");
		myArray.add("civic");
		myArray.add("radar");
		myArray.add("sexes");
		myArray.add("jimmy");
		myArray.add("kayak");
		myArray.add("john");
		myArray.add("refer");
		myArray.add("billy");
		myArray.add("did");
		System.out.println(myArray); // prints out myArray
		
		int x = myArray.size() - 1; // changes int x to the last index within the array
		
		/*
		 * This for loop will loop through each index of myArray.
		 * It will change each word from the array to a StringBuilder 
		 * and reverse the word. The if statement will check to see if String y the 
		 * original word is equal to the value of the reversed StringBuilder.
		 * It will add the strings that are palindromes to a new array called MyArray1.
		 */ 
		for(int i = 1; i <= x; i++) {
			String y = myArray.get(i).toString();
			StringBuilder stringB = new StringBuilder(y);
			StringBuilder stringC = stringB.reverse();
			if (y.equals(String.valueOf(stringC))){
				myArray1.add(y);
			}
		}
		System.out.println(myArray1); // prints an array
		
		
		
	}
}

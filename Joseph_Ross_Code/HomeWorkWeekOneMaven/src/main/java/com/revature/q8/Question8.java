package com.revature.q8;

import java.util.ArrayList;

public class Question8 {
	
	//Stored the original value in an array
	String[] valuesToStore = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
	
	//Create an array list for storing the palindromes
	ArrayList<String> palindromeList = new ArrayList<String>();

	public static void main(String[] args) {
		
		Question8 test = new Question8();
		test.driver();
	}
	
	public void driver() {
		//Create array list to store the original values
		ArrayList<String> originalList = new ArrayList<String>();
		
		//Add the values to the array list
		for(int i = 0; i < valuesToStore.length; i++)
			originalList.add(valuesToStore[i]);
		
		//Printing original list
		System.out.println("Original List:");
		printArrayList(originalList);
		
		//Loop through each word in list to check if its a palindrome
		for(int i = 0; i < originalList.size(); i++) {
			
			//If its a palindrome add the word to the list
			if(isPalindrome(originalList.get(i))) palindromeList.add(originalList.get(i));
		}
		
		System.out.println("\nList of Palindromes:");
		printArrayList(palindromeList);
	}
	
	// Used for printing an array list of words
	public static void printArrayList(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	// Returns true if the passed string is a palindrome and false if its not
	public static Boolean isPalindrome(String word) {
		
		//We make sure letters are all the same case for correct comparisons
		word = word.toLowerCase();
		
		//Strings with 0 or 1 characters are considered palindrome
		if(word.length() == 0 || word.length() == 1) return true;
		
		//Reverse the string for comparison
		String reversedWord = new StringBuilder(word).reverse().toString();
		
		//If the reversed word is equal to the original word then it is a palindrome
		if(reversedWord.equals(word)) return true;
		
		//If the method hasn't returned true at this point the word is not a palindrome
		return false;
	}

}

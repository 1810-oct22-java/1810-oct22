package Question8;

import java.util.ArrayList;

public class Palindrome {
	
	/*
	 * Q8. Write a program that stores the following strings in an ArrayList 
	 * and saves all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, 
	 * “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
	 */

	public static void main(String[] args) {
		
		//Initialize ArrayList with given strings
//		String[] words = {"karan", "madam", "tom", "civic", "radar", "sexes", 
//						"jimmy", "kayak", "john", "refer", "billy", "did" };
//		
//		//call method on Array of words
//		isPalindrome(words);

		
	}

	public ArrayList<String> isPalindrome(String[] words) {
		
		//Initialize 2 empty ArrayLists
		ArrayList<String> arrList = new ArrayList<String>();
		ArrayList<String> isPalin = new ArrayList<String>();
		
				
		for(int i = 0; i < words.length; i++) {
			
			//use same method from Q3(Reverse)
			//reverse the string
			int strlen = words[i].length() - 1;
			
			String reversed = "";
			for(int j = strlen; j >= 0; j--) {
				
				//add each character starting from the last char into a new string hence creating your reversed string
				reversed += words[i].charAt(j);
				
			}

			//if the reversed string has the same value equality as the original string
			//add it to the isPalin ArrayList
			if(words[i].equals(reversed)) {
				
				isPalin.add(words[i]);
				
			}
			
			//otherwise, add to arrList 
			else {
				
				arrList.add(words[i]);
				
			}
			
			//check if palindrome add to respective ArrayList
			
		}
		
		System.out.println("arrList: " + arrList.toString());
		System.out.println("isPalin: " + isPalin.toString());
		
		return isPalin;
		
	}
	
}

/**
 * 
 */
package com.revature.palindromes;

import java.util.ArrayList;
import com.revature.reversestring.ReverseString;

/**
 * Q8: Write a program that stores a list of data in an ArrayList and saves all the 
 *     Palindromes in another ArrayList
 * @author Phil
 *
 */
public class Palindromes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> forward = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		// add the initial forward data
		forward.add("karan");
		forward.add("madam");
		forward.add("tom");
		forward.add("civic");
		forward.add("radar");
		forward.add("sexes");
		forward.add("jimmy");
		forward.add("kayak");
		forward.add("john");
		forward.add("refer");
		forward.add("billy");
		forward.add("did");
		System.out.println("Initial Data: " + forward.toString());
		
		// iterate through the list and save the palandromes
		for (String str: forward) {
			// if the forward string is the same as the reversed then we have a palandrome
			if(isPalindrome(str)) {
				// add it to the palandromes
				palindromes.add(str);
			}
		}
		
		System.out.println("Palindromes: " + palindromes.toString());
	}
	
	/**
	 * returns true if the passed in string is a palindrome and false if not
	 * @param forward
	 * @return
	 */
	public static boolean isPalindrome(String forward) {
		boolean b = false;
		
		// reverse the current string
		String rev = ReverseString.reverse(forward.trim());
					
		// if the forward string is the same as the reversed then we have a palandrome
		if(forward.contains(rev)) {
			b = true;
		}
		
		return b;
	}
}

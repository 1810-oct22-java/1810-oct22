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
			// reverse the current string
			String rev = ReverseString.reverse(str);
			
			// if the forward string is the same as the reversed then we have a palandrome
			if(forward.contains(rev)) {
				// add it to the palandromes
				palindromes.add(rev);
			}
		}
		
		System.out.println("Palindromes: " + palindromes.toString());
	}
}

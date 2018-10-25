/**
 * 
 */
package com.revature.lettercount;

import com.revature.tools.Arguments;

/**
 * Q16:  Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument using (String [] args) 
 * 
 * @author Phil
 *
 */
public class LetterCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = Arguments.validString(args, "onomatopoeia");

		System.out.println(str + " has " + count(str) + " characters.");
	}

	/**
	 * returns the number of characters in the string
	 * @param str
	 * @return
	 */
	public static int count(String str) {
		int count = 0;
		
		// this seems too simple for homework
		// I trimmed off the spaces
		count = str.trim().length();
		
		return count;
	}
}

/**
 * 
 */
package com.revature.reversestring;

import com.revature.tools.Arguments;

/**
 * Q3:  Reverse a string without using a temp variable.  Do not use reverse() in the StringBuffer
 *      or the StringBuilder APIs.
 *      
 * @author Phil
 * 
 */
public class ReverseString {

	/**
	 * Entry point
	 * @param args
	 */
	public static void main(String[] args) {
		// pull the string from the args
		String str = Arguments.validString(args, "Happy Halloween!!!");
		
		// process the reversed string
		System.out.println("Reversing: " + str + "  -->  " + reverse(str));
	}
	
	/**
	 * Do the physical reverse and return the reversed string
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		// reverse the string
		StringBuffer rev = new StringBuffer("");
		for (int x=str.length(); x>0; x--) {
			rev.append(str.charAt(x-1));
		}
		
		return rev.toString();
	}
}

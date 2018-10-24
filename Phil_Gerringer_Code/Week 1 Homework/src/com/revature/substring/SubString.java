/**
 * 
 */
package com.revature.substring;

import com.revature.tools.Arguments;

/**
 * Q5: Write a substring method that accepts a string str and an index idx and
 *    returns the substring between 0 and idx-1 inclusive.  Do not use any of the
 *    existing substring methods in the String, String Builder, or StringBuffer APIs.
 * @author Phil
 *
 */
public class SubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = Arguments.validString(args, "Happy Halloween");
		
		System.out.println(substring(str,8));
	}

	/**
	 * returns a substring based on the beginning str through to the idx
	 * @param str
	 * @param idx
	 * @return
	 */
	public static String substring(String str, int idx) {
		StringBuffer rev = new StringBuffer("");
		for (int x=0; x<idx; x++) {
			rev.append(str.charAt(x));
		}
		
		return rev.toString();
	}
}

/**
 * 
 */
package com.revature.iseven;

import com.revature.tools.Arguments;

/**
 * Q7:  Write a program to determine if an integer is even without using the modulus operator (%)
 * @author Phil
 *
 */
public class IsEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = Arguments.validInt(args, 5);
		
		if(isEven(n)) {
			System.out.println(n + " is even.");
		}
		else {
			System.out.println(n + " is NOT even.");
		}
	}
	
	/**
	 * returns true if n is even and false if its odd
	 * @param n
	 * @return
	 */
	public static boolean isEven(int n) {
		boolean b = true;
		
		// count through the int, each time switching whether its true or not
		for (int i=1; i<=n; i++) {		
		    b = !b; 
		} 
		
		return b;
	}
}

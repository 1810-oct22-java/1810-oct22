/**
 * 
 */
package com.revature.q11;

import com.revature.tools.Arguments;

/**
 * Q11: Write a program that will access two float-variables from a class that 
 * 		exists in another package.  Note, you will need to create two packages
 * 		to demonstrate the solution.
 * @author Phil
 *
 */
public class Q11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Phil's Age: " + Arguments.PHILS_AGE);
		System.out.println("Phil's Height: " + Arguments.PHILS_HEIGHT);
	}

}

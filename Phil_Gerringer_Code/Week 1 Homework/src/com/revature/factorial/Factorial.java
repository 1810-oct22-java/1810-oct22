/**
 * 
 */
package com.revature.factorial;

import com.revature.tools.Arguments;

/**
 * Q4: Write a program to compute N Factorial
 * @author Phil
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int N = Arguments.validInt(args, 5);
		
		System.out.println(N + "! = " + compute(N));
	}
	
	/**
	 * Return the answer to N factorial (N!)
	 * @param N
	 * @return
	 */
	public static long compute(int N) {
		long factorial = 1; // seed 
		
		// qa check the input
		if(N > 0) {
			// run through the N
			for(int i = 1; i <= N; i++) {
				factorial *= i;
			}
		}
		
		return factorial;
	}

}

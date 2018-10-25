/**
 * 
 */
package com.revature.minimum;

/**
 * Q10: Find the mimimum of two numbers using the ternary operators
 * 
 * @author Phil
 *
 */
public class Minimum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(get(7,6));

	}
	
	/**
	 * returns the minimum of two numbers
	 * @param x
	 * @param y
	 * @return
	 */
	public static int get(int x, int y) {
		return x<y ? x : y;
	}

}

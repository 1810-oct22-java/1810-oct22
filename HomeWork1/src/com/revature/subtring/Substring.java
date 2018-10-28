package com.revature.subtring;

/**
 * Write a substring method that accepts a string str
 * @author thienle
 *
 */
public class Substring {
	
	public static void main(String[] args) {
		
		
		System.out.println(newSubstring("Hello world", 5));
	}
	
	/**
	 * Method returns a substring
	 * @param str
	 * @param index
	 * @return
	 */
	public static String newSubstring(String str, int index) {
		
		String result = "";
		
		for(int i = 0; i < index; i++) {
			result += str.charAt(i);
		}
		
		return result;
	}

}

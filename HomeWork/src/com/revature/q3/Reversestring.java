package com.revature.q3;

public class Reversestring {

	public static void main(String[] args) {

		String input = null;
		
		//prints the result of the string backwards
		String result = reverse(input);
		System.out.println(result);
	}
	
	/*
	 * reads original string backwards, adding
	 * each character from each iteration to
	 * the new string
	 */
	public static String reverse(String input) {
		String reverse = "";
		for(int i = input.length()-1; i >= 0; i--) {
			reverse = reverse + input.charAt(i);		
		}
		return reverse;
	}

}

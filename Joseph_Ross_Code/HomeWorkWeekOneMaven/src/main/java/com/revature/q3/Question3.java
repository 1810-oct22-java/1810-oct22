package com.revature.q3;

public class Question3 {

	public static void main(String[] args) {
		
		//Store the string to be reversed
		String s = "Reverse me";
		
		System.out.println(reverseString(s));
	}
	
	public static String reverseString(String s) {
		//Save the length of the string
		int size = s.length();
		
		//Append the reverse order of the sting to the original string
		for(int i = size - 1; i >= 0; i--) {
			s = s + s.charAt(i);
		}
		
		//Remove the original text from the original string
		s = s.substring(size, size * 2);
		
		return s;
	}

}

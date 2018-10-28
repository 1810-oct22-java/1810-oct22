package com.revature.q5;

import java.util.Scanner;

public class SubstringInt {

	public static void main(String[] args) {
		//user enters input of a string and integer
		System.out.println("Enter a String");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println("Enter an integer");
		int idx = in.nextInt();
		
		//calls the method to get the substring 
		//and prints it
		String result = subStr(str, idx);
		System.out.println(result);

	}
	
	//method takes a string input and an integer and builds the 
	//string up to the length of the integer
	public static String subStr(String str, int idx) {
		String result = "";
		for(int i = 0; i <= idx-1; i++) {
			result = result + str.charAt(i);
		}	
		return result;
	}

}

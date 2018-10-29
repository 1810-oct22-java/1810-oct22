 package com.HW1.question03;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Reverse();
	}

	public static void Reverse(){
    	try {
    		/*
    		 * Takes in a string and reverse it
    		 * by adding the last index first and going backwards until the first index is last
    		 * For example the word "home"
    		 * home -> omeh -> meho-> ehom
    		 */
    		System.out.println("Insert String: ");
    		Scanner read = new Scanner(System.in);
    		String userInput = read.next();
    		
    		read.close();
    		for(int i = 0; i < userInput.length();i++) {
    			userInput = userInput.substring(1, userInput.length() -i) 
    					+ userInput.charAt(0) 
    					+ userInput.substring(userInput.length() - i);
    		}
    		System.out.println(userInput);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
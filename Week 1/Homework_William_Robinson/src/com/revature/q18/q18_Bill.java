package com.revature.q18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q18_Bill extends q18_Bill_super {

	public static void main(String[] args) {
	    q18_Bill q18 = new q18_Bill();
	    String a = "Here we are";
		q18.hasUpperCaseChar(a);
		
		/*	Write a program having a concrete subclass 
	 * that inherits three abstract methods from a 
	 * superclass. Provide the following three 
	 * implementations in the subclass corresponding 
	 * to the abstract methods in the superclass:
			
			1. Check for uppercase characters in a 
			string, and return ‘true’ or ‘false’ 
			depending if any are found.
			2. Convert all of the lower case characters
			 to uppercase in the input string, and return 
			 the result.
			3. Convert the input string to integer and 
			add 10, output the result to the console.
			Create an appropriate class having a main method 
			to test the above setup. */
			
		 
	}

	@Override
	public  boolean hasUpperCaseChar(String s) {
		if(s.equals(null)||s.equals("")|| !s.matches("\u0041-\u005a")) {
			System.out.println("false");
			return false;
		}else {
			//Matcher m = m.matches("\u0041-\u005a");
			s.matches("\u0041-\u005a");
			boolean b = s.matches("\u0041-\u005a");
		for (int i = 0; i < s.length(); i++) {
			    
			if (b || s.matches("[^\u0041-\u005a]")) {
				System.out.println("true");
				return true;
			} else {
				System.out.println("false");
				return false;
			}
		  }
		} return true;
	}
	@Override
	public char toUpperCase(String s) {
		if(s.equals(null)||s.equals("")) {
			return 0;
		}else {
			Matcher m = m.matches('\u0041'-'\u005a');
			boolean b = m.matches('\u0041'-'\u005a');
		for (int i = 0; i < s.length(); i++) {
			
		/*	if (b) {
				return s;
			} else
				return s;//(s.charAt(i)== regex('A'...'Z'));
		   */
		  
		}
		return 0;
	}
	}
	@Override
	public Integer convertStringtoInteger(String s) {
		if(s.equals(null)||s.equals("")) {
			return null;
		}else {
			Integer a = new Integer(a.parseInt(s));
			return a;
		}
	
	}

}

package com.revature.h3;

public class reverseString {
	public static void main(String[] args) {
		String rev = "Reverse!";
		for(int i = 0; i < rev.length(); i++)
		{
		    rev = rev.substring(1, rev.length() - i) + rev.charAt(0)
		    + rev.substring(rev.length() - i);
		}
		System.out.println(rev);
	  
	}
	
}

package com.revature.reversedstring;

import java.util.ArrayList;

public class ReversedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReversedString r = new ReversedString();
		
		System.out.println(r.reverseString("Hello"));
	}
	

	
	
	
	public String reverseString(String str) {
		
		String reverse = "";
		
		if(str.length()==1) return str;
		reverse += str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() -1 ));
		
		return reverse;
		
	}

}

package com.revature.q3;

import java.util.*;

public class q3_Bill {
//Reverse a string without using a temporary variable. 
//	Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) {
		 
		String s = "Hello. This is a string";
		StringBuilder sb = new StringBuilder(); 
		for(int i = s.length()-1; i>= 0; i--) {
			
				sb.append(s.charAt(i));
					
		}
		System.out.println(sb);

	}

}

package com.revature.q5;

public class Question5 {
	
	public static String substring(String str,int idx) {
		
		//if idx is negative the return an empty string
		if(idx < 0) return "";
		
		//If idx is greater than the length of the string then return the whole string
		if(str.length() < idx) return str;
		
		//A temp var to store the result
		String result = "";
		
		//A loop for adding each needed char to result
		for(int i = 0; i < idx; i++) {
			
			//Add the 
			result = result + str.charAt(i);
		}
		return result;
	}

}

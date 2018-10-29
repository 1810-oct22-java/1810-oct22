package com.revature.hw5;

public class subString {
	
	public static String subStr(String str, int idx) {
		String sub = " ";
		for(int i = 0; i <= idx; i++) {
			sub += str.charAt(i);
			
		}
		return sub;
	}
	
	public static void main(String[] args) {
		subString s = new subString();
		System.out.println(s.subStr("Hello World! I am back!", 11));
	}
	
}

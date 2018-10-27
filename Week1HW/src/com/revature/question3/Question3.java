package com.revature.question3;

public class Question3 {
	
	public static void main(String[] args) {
		String str = "gnirts a si sihT";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(str.length());
		for (int i = str.length()-1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		str = sb.substring(str.length());
		System.out.println(str);
	}

}

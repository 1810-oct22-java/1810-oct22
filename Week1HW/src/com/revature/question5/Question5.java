package com.revature.question5;

public class Question5 {
	
	public static void main(String[] args) {
		String str = "My Name is Ted";
		String s = substring(str, 6);
		System.out.println(s);
	}
	
	public static String substring(String str, int idx) {
		StringBuilder sb = new StringBuilder(str);
		sb.delete(idx,sb.length());
		return sb.toString();
	}

}

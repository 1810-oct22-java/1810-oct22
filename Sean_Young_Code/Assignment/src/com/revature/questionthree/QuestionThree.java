package com.revature.questionthree;

public class QuestionThree {
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(stringReverse(s));
	}

	public static String stringReverse(String s) {
		String reversedString = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversedString = reversedString + s.charAt(i);
		}
		return reversedString;

	}
}

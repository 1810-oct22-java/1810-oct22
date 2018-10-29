package com.HW1.question05;

public class Substring {
	/*
	 * Takes in a string and an integer to find the index location on the string
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(SubStr("help I couldn't get the scanner to work", 2));
	}

	private String str;

	public static String SubStr(String str, int Idx) {
		try {
			System.out.println("Enter word and index");
			String word = "";
			for (int i = Idx; i < str.length(); i++) {
				word += str.charAt(i);
			}
			// System.out.println(SubStr());
			return new String(word);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return " Insert substring(string, integer)";
	}
}
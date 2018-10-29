package com.HW1.question08;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindromes {
	public static void main(String[] args) {
		palindromes();
	}

	public static void palindromes() {
		/*
		 * Stores the words in a array, and searches the array for the reverse of the word
		 * if a palindromes is found then it adds it to another list.
		 * 
		 */
		String[] wordList = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer",
				"billy", "did" };

		ArrayList<String> paliList = new ArrayList<String>();

		for (String word : wordList) {
			StringBuilder sb = new StringBuilder();
			String pali = sb.append(word).reverse().toString();
			
			if (word.equals(pali)) {
				paliList.add(word);
			}
		}
		System.out.println(Arrays.toString(wordList));
		System.out.println(paliList);
	}
}

package com.revature.hw8;

import java.util.ArrayList;

public class palidromeArray {
	
public static void main(String[] args) {
		
	ArrayList<String> word = new ArrayList<String>();
	
	ArrayList<String> pal = new ArrayList<String>();
		
	word.add("karan");
	word.add("madam");
	word.add("tom");
	word.add("civic");		
	word.add("radar");
	word.add("sexes");
	word.add("jimmy");
	word.add("kayak");
	word.add("john");
	word.add("refer");
	word.add("billy");
	word.add("did");
		
		for(int i = 0; i < word.size(); i++) {
			if(isPalindrome(word.get(i))) {
				pal.add(word.get(i));
			}
		}
		
		for(int i = 0; i < pal.size(); i++) {
			System.out.println(pal.get(i));
		}

		
	}
	
	static Boolean isPalindrome(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString().equals(word);
	}
	
	

}

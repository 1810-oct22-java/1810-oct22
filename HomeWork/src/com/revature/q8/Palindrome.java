package com.revature.q8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		
		//creates ArrayList of String and adds the following strings to it
		ArrayList<String> ar = new ArrayList<>();
		ar.add("karan");
		ar.add("madam");
		ar.add("tom");
		ar.add("civic");
		ar.add("radar");
		ar.add("sexes");
		ar.add("jimmy");
		ar.add("kayak");
		ar.add("john");
		ar.add("refer");
		ar.add("billy");
		ar.add("did");
		
		//creates an ArrayList of String, used for palindromes
		ArrayList<String> pald = new ArrayList<>();
		
		//iterates through original ArrayList
		//if the string is the same as it is reverse
		//then it is added to palindrome ArrayList
		for(int i = 0; i < ar.size(); i++) {
			String reverse = new StringBuilder(ar.get(i)).reverse().toString();
			if(ar.get(i).equals(reverse)) {
				pald.add(reverse);
			}
		}
		
		//prints palindrome ArrayList
		for(int i = 0; i < pald.size(); i++) {
			System.out.println(pald.get(i));
		}

	}

}

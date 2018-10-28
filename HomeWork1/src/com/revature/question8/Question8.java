package com.revature.question8;

import java.util.Scanner;
import java.util.ArrayList;



public class Question8 {
	
	public static void main(String[] args) {
		
		
		String line = "“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”";
		
//		ArrayList<String> ar = storeWord(line);
//		for(String i : ar) {
//			System.out.println(i);
//		}
		//System.out.println(isPalindrome("madaM"));
		
		storePalindrome(storeWord(line));
	}
	
	
	public static void storePalindrome(ArrayList<String> ar) {
		
		
		for(String i : ar) {
			
			if(isPalindrome(i)) {
				System.out.println(i);
			}
		}
		
	}
	
	public static ArrayList<String> storeWord(String str) {
		
		Scanner scan = new Scanner(str);
		
		ArrayList<String> arr = new ArrayList<String>();
		
		String word = "";
		
		while(scan.hasNext()) {
			
			word = scan.next();
			
			if(word.endsWith(",")) {
				word = word.substring(1, word.length()-2);
			} else {
				word = word.substring(1, word.length()-1);
			}
			
			arr.add(word);
			
		}
		
		return arr;
		
	}
	
	public static boolean isPalindrome(String str) {
		
		StringBuilder sb = new StringBuilder(str);
	
		
		return sb.reverse().toString().equalsIgnoreCase(str);
	}

}

package com.revature.question8;

import java.util.ArrayList;

public class Question8 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> pals = new ArrayList<String>();
		String[] str = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		
		//FOR EACH loop
		for (String s : str) {
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			list.add(s);
			if (sb.toString().equals(s)) {
				pals.add(s);
			}
		}
		System.out.println(list);
		System.out.println(pals);
		
	}
}

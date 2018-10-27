package com.revature.question8;

import java.util.ArrayList;

public class Question8 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> pals;
		String[] str = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		for (String s : str) {
			list.add(s);
		}
		pals = pal(str);
		System.out.println(pals);
	}
	
	public static ArrayList<String> pal (String[] str){
		ArrayList<String> pals = new ArrayList<String>();
		//FOR EACH loop
		for (String s : str) {
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			if (sb.toString().equals(s)) {
				pals.add(s);
			}
		}
		return pals;
	}
}

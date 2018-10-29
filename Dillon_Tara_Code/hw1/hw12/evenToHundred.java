package com.revature.hw12;

public class evenToHundred {
	public static void main(String[] args) {
		int n = 100;
		int [] numbers = new int[n];
		for(int i = 1; i <= n; i++) {
			numbers[i - 1] = i;
		}
		
		for (int j : numbers) {
			if (j % 2 == 0) { System.out.println(j + "");}
		}
	
	}
	
	
}

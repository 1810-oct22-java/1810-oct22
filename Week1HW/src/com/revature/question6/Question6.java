package com.revature.question6;

public class Question6 {
	public static void main(String[] args) {
		int n = 39;
		System.out.println(isEven(n));
	}
	
	public static boolean isEven(int n) {
		if (n/2*2 == n) {
			return true;
		}
		else {
			return false;
		}
	}
}

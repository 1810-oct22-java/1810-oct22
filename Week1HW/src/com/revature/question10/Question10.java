package com.revature.question10;

public class Question10 {
	public static void main(String[] args) {
		int n = 3;
		int m = 4;
		System.out.println(min(n,m));
	}
	
	static int min(int n, int m) {
		return n < m ? n : m;
	}
}

package com.revature.hw2;

public class fibonacciSequence {
	
	public static int n1 = 0, n2 = 1, n3 = 0;
	
	public static void main(String[] args) {
		int count = 25;
		System.out.println(n1 + "" + n2);
		printFib(count - 2);
		}
	
	public static void printFib(int count) {
		if(count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		System.out.println("" + n3);
		printFib(count - 1);
		}
	}
}

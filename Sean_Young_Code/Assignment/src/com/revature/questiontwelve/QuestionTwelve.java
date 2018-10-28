package com.revature.questiontwelve;

public class QuestionTwelve {
	private static int k;

	public static void main(String[] args) {
		
		Integer[] myIntArray = new Integer[100];
		//adds numbers from one to 100.
		for(int i = 0; i < myIntArray.length; i++) {
			myIntArray[i] = i + 1;
		}
		//uses an enhanced for loop to print out even integers. k as a static variable is default to the value of 0
		// While using this modulus operator if the returned value is 0 it will print out the number which should
		// be even
		for(int i : myIntArray) {
			if(k == i % 2) {
				System.out.println(i);
			}
			
			
		}
	}
}

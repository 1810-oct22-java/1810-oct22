package com.revature.question13;

public class Question13 {

	//no JUNIT tests as there is only a main method that prints to the console 
	public static void main(String[] args) {
		int row = 0;
		int k=2;
		int i;
		for (i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.print("0 ");
			}
			else {
				System.out.print("1 ");
			}
			if (i == row) {
				System.out.println("");
				row = row+k;
				k++;
			}
		}
	}
	
}

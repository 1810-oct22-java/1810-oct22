package com.revature.question2;

public class Question2 {
	
	public static void main(String[] args) {
		int temp1=0;
		int temp2=1;
		System.out.print("0, 1, ");
		for (int i = 0; i<23; i++) {
			if (i%2 == 0) {
				System.out.print((temp1+temp2)+", ");
				temp1 = temp1+temp2;
			}
			else {
				System.out.print((temp1+temp2)+", ");
				temp2 = temp1+temp2;
			}
		}
	}

}

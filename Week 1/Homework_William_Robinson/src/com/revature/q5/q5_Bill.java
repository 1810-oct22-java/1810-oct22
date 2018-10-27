package com.revature.q5;

import java.util.Scanner;

public class q5_Bill {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String str = scanner.nextLine();
		System.out.println("Please enter an integer to return beginning to"
				+ " last character "
				+ "of the string inclusive");
		int idx = scanner.nextInt();
		for(int i = 0; i < idx; i++) {
		System.out.print(str.charAt(i) );
		}


	}

}

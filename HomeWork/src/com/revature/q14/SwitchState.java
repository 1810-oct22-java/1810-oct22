package com.revature.q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SwitchState {

	public static void main(String[] args) {
		//user input
		System.out.println("Enter...");
		Scanner in = new Scanner(System.in);
		int opt = in.nextInt();
		
		//user can enter a number for square root, print local date, or a message 
		//with the words split into a String array
		switch(opt) {
		case 1: 
			System.out.println("Enter number");
			int num = in.nextInt();
			int sq = (int) Math.sqrt(num);
			System.out.println("Square root is: " + sq);
			break;
		
		case 2:
			LocalDate date = LocalDate.now();
			System.out.println(date);
			break;
		
		case 3:
			String str = "I am learning Core Java";
			String [] arr = new String[6];
			int i = 0;
			for(String s: str.split(" ")) {
				arr[i] = s;
				System.out.println(arr[i]);
				i++;
			}
			break;
			
		
		}

	}

}

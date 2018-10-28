package com.revature.questionFourteen;

import java.util.Date;
import java.util.Scanner;

public class QuestionFourteen {
	public static void main(String[] args) {
		int switchNum = 0; // creates a static variable switchNum to change the input of the switch statement
		Date d = new Date(); // creates an instance of the Date class 
		System.out.println("Enter a value in between 1 & 3: ");
		Scanner scan = new Scanner(System.in); // takes user input from 1 -3
		switchNum = scan.nextInt();
				switch(switchNum){
				//if the user enters 1 the switch statement will output the square root of 50.
					case 1:
						System.out.println("The square root of 50 is " + Math.sqrt(50));
						break;
				//If the user enters 2, the console will return today's date.
					case 2:
						System.out.println("Today's date is " + d);
						break;
				//Will print out 
					case 3:
						String s = "I am learning core Java";
						String[] newString = s.split(s);
						System.out.println(newString.toString());
						break;
				}
	}
}

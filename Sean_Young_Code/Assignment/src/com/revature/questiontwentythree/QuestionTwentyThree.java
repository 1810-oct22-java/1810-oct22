package com.revature.questiontwentythree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QuestionTwentyThree {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Date as a string to convert to Date format (dd/MM/yyyy): ");
		String str = scan.nextLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
		System.out.println(date);
}
}

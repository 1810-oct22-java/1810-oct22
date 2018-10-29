package com.HW1.question23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Takes in a number date in the format mm/dd/yyyy and return EEE, MMM d, yyyy
 * for example, user input 12/20/1996 -> Fri, December 20,1996
 * 
 */


public class StringToDate {
	public static void main(String[] args) {
		StrToDate();
	}
	public static String StrToDate() {
		try {
			System.out.println("Insert mm/dd/yyyy as numbers: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String userDate = br.readLine();
			
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(userDate);
				
			String finalDate = new SimpleDateFormat("EEE, MMMM d, yyyy").format(date);
			System.out.println("New Date: " + finalDate);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return " Insert mm/dd/yyyy ";
	}
}
package com.HW1.question25;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RomanNumeralRepresentation {
	/*
	 * Takes in user input to check if it is greater than or equal to zero. If the
	 * user inserts an integer it will take the number and divide it by the numbers
	 * in the arabic number array. If it return zero, then we know the number is one
	 * the arabic numbers.
	 * 
	 * If not then we still need divide by each number in the arabic number array
	 * Then it add the roman number to an empty string until the input number mod the arabic number.
	 * If there is a remainder then it becomes the new user input and we can add the remainder to the string
	 * 
	 * 3 -> will only be divisible by 1 in the arabic number array
	 * So, we start with one which is "I" in roman numerals
	 * answer = ""; -> "II" 
	 * checks for the remainder and the final answer is s"III"
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(Conversion());
	}

	static String Conversion() {
		try {
			System.out.println("Insert integer to convert to Roman Numerals: ");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();

			String[] romanNum = { "M", "CM", "D", "XD", "C", "XC", "L", "XX", "X", "V", "IV", "I" };
			int[] arabNum = { 1000, 900, 500, 490, 100, 90, 50, 20, 10, 5, 4, 1 };
			String answer = "";
			scan.close();

			int temp;
			if (input <= 0) {
				return "Please insert a number greater than 0";
			}
			for (int i = 0; i < romanNum.length; i++) {

				temp = input / arabNum[i];
				System.out.println(temp);
				if (temp == 0) {
					// System.out.print(temp);
					continue;
				}

				for (int j = 0; j < temp; j++) {
					System.out.println(answer);
					answer += romanNum[i];
				}
				System.out.println(input);
				input = input % arabNum[i];

			}
			return answer;
		} catch (InputMismatchException ime) {
			ime.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return " Please insert an integer!";
	}
}

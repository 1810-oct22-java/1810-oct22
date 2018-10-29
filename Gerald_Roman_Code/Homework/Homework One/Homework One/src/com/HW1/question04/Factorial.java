package com.HW1.question04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		number();
	}

	public int factorial(int number){
		/*
		 * Recursive function which takes in the original number (n) and multiplies
		 * (n-1) until n == 1 or n == 0, where it will return 1.
		 * 
		 * Fac(5) -> 5*Fac(4) -> 5*4*Fac(3) -> 5*4*3*Fac(2) -> 5*4*3*2*Fac(1) ->
		 * 5*4*3*2*1 = 120
		 * 
		 */
		try {
			if ((number == 0) || (number == 1)) {
				return 1;
			}else if(number < 0) {
				System.out.print("Error: Please insert an integer greater than or equals to ");
				return 0;
			}
			return (number * factorial(number - 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void number() {
		try {
			Factorial fact = new Factorial();
			Scanner scan = new Scanner(System.in);
			System.out.println("Insert integer to factor: ");
			int number = scan.nextInt();
			System.out.println(fact.factorial(number));
			scan.close();

		} catch (InputMismatchException imm) {
			System.out.println("Insert an integer!");
			imm.printStackTrace();
		}
	}
}

//package question.Two;
package com.HW1.question02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		fibonacciNumbers();
	}

	static void fibonacciNumbers() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Insert integer: ");
			int Max = scan.nextInt();
			scan.close();
			
			int Fn1 = 0;
			int Fn2 = 1;
			int total = 0;
			for (int i = 0; i <= Max; ++i) {
				total = Fn1 + Fn2;

				Fn1 = Fn2;
				Fn2 = total;
				System.out.print(Fn1 + " ");
			}
		} catch (InputMismatchException imm) {
			System.out.println("Insert a integer!");
			imm.printStackTrace();
		}
	}
}

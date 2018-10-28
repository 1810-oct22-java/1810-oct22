package com.revature.factorial;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * compute N factorial
 * @author thienle
 *
 */
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		System.out.println(factorial(6));
		}
		catch(IOException e) {
			System.out.println("wrong input");
		}

	}
	
	/*
	 * Recursive method to compute N factorial
	 */
	public static int factorial(int num) throws IOException {
		
	
		if(num == 0) return 1;
		return  num * factorial(num - 1);
		
		
	}

}

package com.revature.fibonacci;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Find fibonacci numbers
 * @author thienle
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i <= 25; i++) {
			System.out.println(fib(i));
		}
		

	}
	
//	public static int[] fib(int num) {
//		
//		
//		int[] feb = new int[num];
//		
//		feb[0] = 0;
//		feb[1] = 1;
//		
//		for (int i = 2; i < num; i++) {
//			
//			
//			feb[i] = feb[i-1] + feb[i-2];
//			
//		}
//		return feb;
//	}
	
	/**
	 * Recursive call to find fibonacci number
	 * @param num
	 * @return
	 */
	public static long fib(int num) {
		
		if(num==0) return 0;
		else if(num <= 2) return 1;
		else return fib(num-1) + fib(num-2);
		
	}
	
	

}

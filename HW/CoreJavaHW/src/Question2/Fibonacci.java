package Question2;

import java.util.ArrayList;

public class Fibonacci {
	
	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
	
	public static void main(String[] args) {
			
		//Fibonacci - sequence of numbers where each number is the sum of 2 preceding numbers.			
		//initialize a number to display the first 25 fibonacci numbers
		
//		int num = 25;
//		//call method
//
//		FibonacciSeq(num);
			
	}
		
	public ArrayList<Integer> FibonacciSeq(int fib) {
			
		//instantiate ArrayList to return for testing
		ArrayList<Integer> fibNums = new ArrayList<Integer>();
		
		//first 2 numbers are 0 and 1
		int f1 = 0;
		int f2 = 1;
			
		//display numbers in the fibonacci sequence 'fib' times
		for (int i = 0; i < fib; i++) {
			
			//print out each number in the sequence starting with 0
			System.out.print(f1 + " ");
			fibNums.add(f1);
			
			
			//add the 2 preceding numbers to get the next
			int num = f1 + f2;
			
			//replace the values of the variables holding the 2 preceding numbers 
			f1 = f2;
			f2 = num;
			
		}
		
		return fibNums;
			
	}

}

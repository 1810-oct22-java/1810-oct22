/**
 * 
 */
package com.revature.fibonacci;

import com.revature.tools.Arguments;

/**
 * Q2: Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * 
 * @author Phil
 */
public class Fibonacci {
	static int NUM_TERMS = 25;
	static int BEG_AT = 0;
	static int SEED_NULL = 0;
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.generateFibonacci(BEG_AT, Arguments.validInt(args, NUM_TERMS));
	}
	
	/**
	 * Method to generate and print Fibonacci numbers
	 * 
	 * @param start
	 * @param terms
	 */
	public void generateFibonacci(int start, int terms) {
		System.out.println("First " + terms + " Fibonacci Numbers Beginning at " + start + ":");
		
		int count = 1;
		
		// set up the first seed
		int seed1 = start;
		print(seed1, count);
		count++;
		
		// set up the second seed
		int seed2 = seed1 + 1;
		print(seed2, count);
		count++;
		
		// cycle through generating/processing the next number in the sequence
		while(count <= terms) {
			//get the next number
			int next = nextNumber(seed1, seed2);
			print(next, count);
			count++;
			
			// now swap the numbers
			seed1 = seed2;
			seed2 = next;
		}
	}
	
	/**
	 * Method to compute the next number by adding the seeds
	 * @param seed1
	 * @param seed2
	 * @return
	 */
	public int nextNumber(int seed1, int seed2) {
		return(seed1 + seed2);
	}
	
	/**
	 * Method to print out the number based on a specific format
	 * @param i
	 * @param count
	 */
	public void print(int i, int count) {
		System.out.println(count + ")\t" + i);
	}

}

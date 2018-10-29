package com.revature.q2;

public class Question2 {
	
	public static void main(String[] args) {
		
		// Printing first 25 numbers of fibonacci sequence
		fibonacci(25);
	}
	
	public static String fibonacci (int n) {
		
		// F(n) = F(n - 1) + F(n - 2)
		// Because the next number in the sequence is dependent
		// on the last two numbers in the sequence. I save the last
		// two numbers
		int last = 0;
		int current = 0;
		
		//Will have same value as console output, then be returned at the end
		String result = "";
		
		// i = 0 because that is where we were asked to start
		for(int i = 0; i < n; i++) {
			
			// This is needed to get the sequence started because we don't
			// have a previous two numbers to add together.
			if(i == 0 || i == 1) {
				last = i;
				current = i;
			} else {
				
				// Store the next number in the sequence in temp
				int temp = last + current;
				
				// Make the current value the last value
				current = last;
				
				// Store the value of temp into last
				last = temp;
			}
			
			// Print the current number in the sequence
			System.out.println(current);
			
			//Append current number in the sequence to result
			result += current + "\n";
		}
		
		return result;
	}
}

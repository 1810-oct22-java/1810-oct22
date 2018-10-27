package Question12;

import java.util.ArrayList;
import java.util.Arrays;

public class EvenNum {
	
	//Q12. Write a program to store numbers from 1 to 100 in an array. 
	//	Print out all the even numbers from the array. Use the enhanced 
	//	FOR loop for printing out the numbers.
	
	public static void main(String[] args) {
		
		//initialize a number to start and end from
//		int i = 1, j = 100;
//		printEven(i, j);
		
	}

	 public ArrayList<Integer> printEven(int i, int j) {
		
		 int nums[] = new int[j];
		 ArrayList<Integer> evenNums = new ArrayList<Integer>();
		 
		 for(int x = i; x <= j; x++) {
			 
			 nums[x - 1] = x;
			 
		 }
		 
		 for(int a : nums) {
			 
			 //same concept as Q6
			 if(((a / 2) * 2) == a) {
				 
				 //add even numbers to another arraylist for testing
				 evenNums.add(a);
				 
				 //display even numbers 
				 System.out.print(a + " ");
				 
			 }
			 
		 }

		 //test print
//		 System.out.println(evenNums);
		 
		return evenNums;
		 
	}

}

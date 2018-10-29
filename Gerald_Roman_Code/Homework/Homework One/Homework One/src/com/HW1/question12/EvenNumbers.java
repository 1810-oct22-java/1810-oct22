package com.HW1.question12;

import java.util.ArrayList;

public class EvenNumbers {
	/*
	 * creates an list of 100 numbers and add in the numbers from 1 to 100
	 * then it searches through the list for even numbers and adds it to an array
	 * 
	 * To check for even numbers, we looking at the bits
	 * since bits are 2^(x) any number that returns zero as the last digit will
	 * be divisible by 2. In our if statement, if the returning bits for the number and 1 
	 * equals 0 then it adds it to the array. If not, then it doesn't do add it
	 * to the array.
	 * 
	 *   0001 (1)						0001 (1)
	 *  &0011 (3)					   &0100 (4)
	 *   0001 which is 1				0000 which is zero
	 *  
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int[] nums = new int[100];
		for (int i = 0; i < nums.length;i++) {
			nums[i] = i + 1;
		}
		for (int n : nums) {
			if((n & 1) == 0) {
				arrList.add(n);
			}
		}
		System.out.println(arrList);
	}
}

package com.revature.q6;


public class IsEven {

	public static void main(String[] args) {
		//input
		int input = 0;
		//calls isEven method
		isEven(input);

	}
	
	//method divided integer by 2, then multiplies it by 2
	// if the result is the same, then its even
	public static boolean isEven(int num) {
		int num_divided = num/2;
		
		if(num_divided * 2 == num) {
			return true;
		} else {
			return false;
		}
		
	}

}

package com.revature.q10;

public class Question10 {
	
	public static int getMin(int n1, int n2) {
		
		//If n1 is greater than n2 return n2
		//If n1 is not greater than n2 return n1
		//If n1 and n2 are equal return n1
		return (n1 >= n2) ? n2 : n1;
	}
}

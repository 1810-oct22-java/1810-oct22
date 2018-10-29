package com.revature.q6;

public class Question6 {
	
	//Note: 0 is assumed to be an even number
	public static boolean isEven(int n) {
		
		// We get the absolute value because it does not change
		// whether the number is even or odd
		n = Math.abs(n);
		
		while(true) {
			//If subtracting n by 2 eventually gives us 1, then n was odd
			if(n == 1) return false;
			
			//If subtracting n by 2 eventually gives us 0, then n was even
			if(n == 0) return true;
			
			//Else if n is not 1 or 0 then subtract by 2 until it is
			n = n - 2;
		}
	}

}

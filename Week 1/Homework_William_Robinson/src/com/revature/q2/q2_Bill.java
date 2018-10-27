package com.revature.q2;

public class q2_Bill {

	// Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public static void main(String[] args) {
		
		createFib();
	}
	public static void createFib() {
		int[] fibonacci = new int[25];
		for(int i = 0; i<fibonacci.length; i++) {
			  if (i ==0) {
				  fibonacci[i] = 0;
				  System.out.println(0);
			  }
			  else if (i ==1) {
				  fibonacci[i] = 1;
				  System.out.println(1);
			  }
			  else if (i==2) {
				  fibonacci[i] = 1;
				  System.out.println(1);
			  }
			  else if (i==3) {
				  fibonacci[i] = 3;
				  System.out.println(3);
			  }
			  else if (i==4) {
				  fibonacci[i] = 5;
				  System.out.println(5);
			  }
			  else {
				  
				  fibonacci[i] +=  fibonacci[i-1] + fibonacci[i-2];
				  System.out.print(fibonacci[i] + " ");
			  }
			 // System.out.println(fib);
		}
	}
	
}

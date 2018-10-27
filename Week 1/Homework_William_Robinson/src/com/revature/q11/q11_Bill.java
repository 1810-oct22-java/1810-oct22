package com.revature.q11;

import com.revature.q26.q26_Bill;

public class q11_Bill {

	public static void main(String[] args) {
	/*	Write a program that would access two 
	 float-variables from a class that exists 
	 in another package. Note, you will need to 
	 create two packages to demonstrate the solution.
     */
		q26_Bill q26 = new q26_Bill();
		float first =  q26.frog;
		float second = q26.tadpole;
		
		System.out.println("The two float values in other package are: ");
		System.out.println(first);
		System.out.println(second);
		
	}

}

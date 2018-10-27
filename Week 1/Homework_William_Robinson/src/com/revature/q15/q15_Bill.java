package com.revature.q15;
 


interface MathOperators{
	
	int  addition(int a, int b);
	int subtraction(int a, int b);
	int multiplication(int a, int b);
	int division(int a, int b);
	
}
  
public class q15_Bill implements MathOperators{

	public int addition(int a, int b) {
		return a + b;
	}
	
	public int subtraction(int a, int b) {
		return a - b;
	}
	
	public int multiplication(int a, int b) {
		return a * b;
	}
	
	public int division(int a, int b) {
		return a / b;
	}
	
	
		/*
		 Write a program that defines an 
		 interface having the following methods: 
		 addition, subtraction, multiplication, 
		 and division. Create a class that 
		 implements this interface and provides 
		 appropriate functionality to carry out 
		 the required operations. Hard code two 
		 operands in a test class having a 
		 main method that calls the implementing 
		 class. 
		 */
		

	

}

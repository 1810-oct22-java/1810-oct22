package com.revature.q15;

public class Question15 {

	public static void main(String[] args) {
		
		double op1 = 2.0;
		double op2 = -8.0;
		
		Calculator myCalc = new SimpleCalculator();
		
		System.out.println(op1 + " + " + op2 + ": " + myCalc.addition(op1, op2));
		System.out.println(op1 + " - " + op2 + ": " + myCalc.substraction(op1, op2));
		System.out.println(op1 + " * " + op2 + ": " + myCalc.multiplication(op1, op2));
		System.out.println(op1 + " / " + op2 + ": " + myCalc.division(op1, op2));
	}
}

interface Calculator {
	public double addition(double n1,double n2);
	public double substraction(double n1,double n2);
	public double multiplication(double n1,double n2);
	public double division(double n1,double n2);
}

class SimpleCalculator implements Calculator {

	@Override
	public double addition(double n1, double n2) {
		
		//No input checking needed
		return n1 + n2;
	}

	@Override
	public double substraction(double n1, double n2) {
		
		//No input checking needed
		return n1 - n2;
	}

	@Override
	public double multiplication(double n1, double n2) {
		
		//No input checking needed
		return n1 * n2;
	}

	@Override
	public double division(double n1, double n2) {
		
		//Zero is returned if n2 is 0 to prevent a divide by 0 error
		if(n2 == 0) return 0;
		return n1/n2;
	}
}

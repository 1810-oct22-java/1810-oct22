package com.revature.q15;

public class q15_testBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               int a = 25;
               int b = 5;
               q15_Bill q15 = new q15_Bill();
             int a1 =  q15.addition(a, b);
             int a2 =   q15.subtraction(a, b);
             int a3 =   q15.multiplication(a, b);
             int a4 =   q15.division(a, b);
               
               System.out.println("Result of addition: "+ a1);
               System.out.println("Result of subtraction: "+ a2);
               System.out.println("Result of multiplication: "+ a3);
               System.out.println("Result of division: "+ a4);
               
	}

}

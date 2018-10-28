package com.revature.evennumber;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Find even number without using %
 * @author thienle
 *
 */
public class EvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("ENter");
		int num = scan.nextInt();
		System.out.println(evenNumber(num));
		
		}
		catch(InputMismatchException e) {
			System.out.println("Wrong input");
		}
		
	}
	
	public static boolean evenNumber(int num) throws InputMismatchException {
		
		
		
			int quotient = num / 2;
			if(quotient*2 == num) return true;
			else return false;
			
		
	}

}

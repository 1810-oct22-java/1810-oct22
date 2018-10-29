package com.HW1.question06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindIntergers {
    public static void main(String[] args) {
        FindEvens();
    }
    public static void FindEvens() {
    	try {
    		System.out.println("Enter a number: ");
    		Scanner scan = new Scanner(System.in);
    		int number = scan.nextInt();
    		
    		if((number & 1) == 0) {
    			System.out.println(number + " is even");
    		}else {
    			System.out.println(number + " is odd");
    		}
    		scan.close();
    	}catch(InputMismatchException ime) {
    		System.out.println("Please enter an integer");
    		ime.printStackTrace();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
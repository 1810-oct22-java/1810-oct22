package com.revature.hw10;

import java.util.Scanner;

public class ternayOperator {
	public static void main(String[] args) 
    {
        int num1, num2, result;
  
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Number:");
        num1 = scanner.nextInt();
        System.out.println("Enter Second Number:");
        num2 = scanner.nextInt();
        scanner.close();
        
        
        result = num1 < num2 ? num1:num2;
     
        System.out.println("Smallest Number is:"+ result);
    }
}

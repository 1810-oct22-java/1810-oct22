package com.revature.q19;

import java.util.ArrayList;

public class ArrListFunc {

	public static void main(String[] args) {
		
		//creates ArrayList of numbers 1 to 10
		ArrayList al = new ArrayList();
		for(int i = 0; i < 10; i++) {
			int num = i + 1;
			al.add(num);
			
		}
		
		//prints the ArrayList
		for(int i = 0; i < 10; i++) {
			System.out.print(al.get(i) + ", ");
			
		}
		
		System.out.println();
		
		//prints the even numbers from the ArrayList
		int evenCount = 0;
		for(int i = 0; i < 10; i++) {
			int num = (int) al.get(i);
			if(num % 2 == 0) {
				evenCount = evenCount + num;
			}
		}
		
		System.out.println("Even number sum: " + evenCount);
		
		//prints the odd numbers from ArrayList
		int oddCount = 0;
		for(int i = 0; i < 10; i++) {
			int num = (int) al.get(i);
			if(num % 2 != 0) {
				oddCount = oddCount + num;
			}
		}
		
		System.out.println("Odd number sum: " + oddCount);
		
		for(int i = 0; i < al.size(); i++) {
			int num = (int) al.get(i);
			if(isPrimeNum(num)) {
				al.set(i,0);
			}	
		}
		
	
		//calls the clean method to remove all prime numbers
		while(clean(al) == false) {
			clean(al);
		}
		
		//prints all non prime numbers
		System.out.print("Non prime numbers: ");	
		for(int i = 0; i < al.size(); i++) {
			int num = (int) al.get(i);
			System.out.print(num + ", ");	
		}	
	}
	
	//method determines whether the given number is prime
	public static boolean isPrimeNum(int n) {
	       if (n <= 1) {
	           return false;
	       }
	       for (int i = 2; i <n; i++) {
	    
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }
	
	//method goes through ArrayList, removing any prime numbers
	public static boolean clean(ArrayList al) {
		for(int i = 0; i < al.size(); i++) {
			int num = (int) al.get(i);
			if(num == 0) {
				al.remove(i);
			}	
		}
		for(int i = 0; i < al.size(); i++) {
			int num = (int) al.get(i);
			if(num == 0) {
				return false;
			}	
		}
		return true;
		
	}

}

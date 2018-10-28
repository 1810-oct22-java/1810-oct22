package com.revature.question19;

import com.revature.*;
import com.revature.prime.Prime;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a = insertNumber();
		
		display(a);
		
		System.out.println("Even numbers have been added up " + addEvenNumber(a));
		
		System.out.println("Odd numbers have been added up " + addOddNumber(a));
		
		removePrime(a);
		
		
		
		display(a);

	}
	
	public static ArrayList<Integer> insertNumber() {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			a.add(i);
		}
		
		return a;
		
	
	}
	
	public static void display(ArrayList<Integer> a) {
		
		for(Integer i : a) {
			System.out.print(i + ", ");
		}
		
		System.out.println();
	}
	
	public static int addEvenNumber(ArrayList<Integer> a) {
		
		int total = 0;
		
		for(Integer i : a) {
			
			if(evenNumber(i)) total += i;
		}
		
		return total;
	}
	
public static int addOddNumber(ArrayList<Integer> a) {
		
		int total = 0;
		
		for(Integer i : a) {
			
			if(!evenNumber(i)) total += i;
		}
		
		return total;
	}
	
	public static boolean evenNumber(int num) {
		
		int quotient = num / 2;
		return (quotient*2 == num); 
	}
	
	public static void removePrime(ArrayList<Integer> a) {
		
		for(int i = 0; i < a.size(); i++) {
			
			if(Prime.isPrime(a.get(i))) {
				a.remove(i);
			}
		}
	}

}

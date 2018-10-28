package com.revature.question12;


/**
 * store numbers from 1 to 100 in an array
 * @author thienle
 *
 */
public class Question12 {
	
	public static void main(String[] args) {
		
		printEvenNumber();
	}
	
	
	/**
	 * Store number from 1 to 100 and print 
	 */
	public static void printEvenNumber() {
		
		
		int[] a = new int[100];
		
		for(int i = 0; i < 100; i++) {
			a[i] = i + 1;
		}
		
		
		
		for(int i : a) {
			
			if(i % 2 == 0) {
				
				System.out.print(i + " ");
			}
		}
		
		
	}

}

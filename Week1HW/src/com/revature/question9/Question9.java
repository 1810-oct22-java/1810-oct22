package com.revature.question9;

import java.util.ArrayList;

//no JUNIT as the main method just prints to the console
public class Question9 {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList <Integer>();
		int idx, j, key=1;
		primes.add(1);
		arr.add(1);
		for (int i = 2; i < 100; i++) { // i = 2
			arr.add(i);
			idx=key;
			while (idx>0) {
				j=primes.get(idx-1);
				if (j == 1) {
					primes.add(i);
					key++;
					idx=0;
				}
				else if (i/j*j == i) {
					idx=0;
				}
				else {
					idx--;
				}
			}
		}
		System.out.println(primes);
	}

}

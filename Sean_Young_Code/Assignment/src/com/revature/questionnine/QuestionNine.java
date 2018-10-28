package com.revature.questionnine;

import java.util.ArrayList;

public class QuestionNine {
	public static void main(String[] args) {
		int x =100; // declares a static variable that will used for the size of the array
		int num = 0;
		
		ArrayList<Integer> myArray = new ArrayList<Integer>(x); // declares an Integer array of size x
		
		for(int i = 1; i <= x; i++){
			int counter = 0;
			for(num = i; num >= 1; num--){
				if(i%num == 0){
					counter = counter + 1;
				}
			}
			if (counter == 2){
				myArray.add(i);
			}
		}
		System.out.println("The prime numbers in between 1 & 100 are: \n" + myArray);
	}
}

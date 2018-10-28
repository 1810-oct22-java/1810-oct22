package com.revature.questionthirteen;

public class QuestionThirteen {
	public static void main(String[] args) {
		int z = 12;
		int aNumber = 0;
		/*
		 * This for loop with a nested for loop count from 1 to 12 while incrementing x in the first loop and
		 * decreasing the value of z in the second for loop. Each time the second loop is executed it resets, but
		 * the values in the first loop remain the same. It uses the modulus operator to print either 1 or 0.
		 * Once the value of x is less than or equal to z it stops looping
		 */
		for (int x = 1;x <= z; x++){
			for(int y = 1; y <= x; y++){
				aNumber = z%2;
				System.out.print(aNumber + " ");
				z--;
			}
			
			System.out.println("\n");
			
		}
	}

}

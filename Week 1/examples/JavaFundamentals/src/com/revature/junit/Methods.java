package com.revature.junit;

public class Methods {
	
	
	//add(1, 2) = 3
	//add(1, 2, 3, 841947, 1413)
	//add()
	//add(3)
	//NOT add([1, 2, 5, 6]);
	public int add(int... nums) { 
		/*
		 * VAR ARGS
		 * - variable number of arguments of a specific type
		 * - reference these args in the method as if it were an array
		 * - MUST be the last argument in a method 
		 * - only allowed to have one var args per method
		 */
		int total = 0;
		for(int i : nums) {
			total +=i;
		}
		return total;
	}

}

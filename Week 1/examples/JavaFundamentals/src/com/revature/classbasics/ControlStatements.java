package com.revature.classbasics;

public class ControlStatements {
	/*
	 * Control statements affect the flow of your app
	 * including loops, ifs, whiles, etc
	 * outside of the loops - important keywords to know 
	 * are continue, break, and labels for code
	 */
	public static void main(String[] args) {


		//FOR LOOP for(initialize counter; condition for counter; change value of counter){}
		for(int n = 0; n < 10; n++) {
			System.out.println(n+") This is a for loop!");
		}

		int i = 2;
		for(; ; ) {
			if(i%2==0) {i = i + 2;}
			else {i = i + 3;}

			System.out.print(i + " ");

			if(i == 20) break;
		}
		System.out.println();

		String str = "this is a long string";
		for(int x = 0; x < str.length(); x++) {
			if(str.charAt(x)!=' ') {
				System.out.print(str.charAt(x));
			}
		}

		int[][] twoD = new int[5][4]; //Arrays are NOT dynamically sized
		int counter = 0;
		for(int j = 0; j < twoD.length; j++) {
			for(int k = 0; k < twoD[j].length; k++) {
				twoD[j][k] = counter++;
				System.out.print(twoD[j][k] + " ");
			}
			System.out.println();
		}

		//FOR EACH - "enhanced for loops"
		//at runtime, get converted behind the scenes to a regular for loop
		//used to iterate over arrays or collections
		String[] strings = {"this is a string", "another String", "i'm hungry"};
		for(String s : strings) {
			System.out.println(s.replaceAll(" ", "--"));
		}

		System.out.println("IN WHILE LOOP");
		//WHILE
		int num = 10;
		while(num-- > 1) { //while condition is true, do block of code
			if(num%2==0) {
				continue; //continue to next iteration
			}
			System.out.print(num);
		}

		//DO WHILE
		//while loop we need to happen AT LEAST once
		do{ //while condition is true, do block of code
			System.out.print((num = num/5) + " ");
		} while(num > 5);

		//IF
		boolean cond = true;
		if(cond) {
			//do stuff if cond == true
		}

		//IF ELSE
		if(cond) {

		}
		else {
			//stuff to do if cond == false
		}

		//IF ELSE IF ELSE
		if(cond) {

		}
		else if(num == 5) {

		}
		else if(num > 15) {

		}
		else {

		}

		//SWITCH
		/*
		 * Use only for discrete options. Cannot use switch statements
		 * for ranges of values
		 * can only use primitives that can be cast to int(short, byte, char)
		 *  can use 
		 * enums, and Strings
		 * 
		 * total: byte, short, char, int
		 * Byte, Short, Character, Integer
		 * Enums(enumerations; special classes)
		 * Strings
		 */
		int fromUser = 7;
		System.out.println("IN SWITCH STATEMENT");
		switch(fromUser) {
			case 1:
				System.out.println("1");
				break; //break exits current block of code
				//return 6; //would be unreachable code, which does not compile
			case 7:
				System.out.println("7");
				break;
			case 35:
				System.out.println("35");
				break;
			default:
				System.out.println("non applicable");
		}

	}
}

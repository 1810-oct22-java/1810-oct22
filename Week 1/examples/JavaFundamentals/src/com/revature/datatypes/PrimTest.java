package com.revature.datatypes;

public class PrimTest {

	//pass in number array to be added together and print results
	public static void main(String[] args) {
		int total = 0;
		
		for(String s : args) {
			//for each string (temp name s) in args, do something
			int num = Integer.parseInt(s); //NOT considered casting since it uses a method call
			total = total + num;
		}
		
		System.out.println("TOTAL: " + total);
	}

}

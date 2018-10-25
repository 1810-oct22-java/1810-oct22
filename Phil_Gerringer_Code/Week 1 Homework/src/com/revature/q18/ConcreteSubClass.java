/**
 * 
 */
package com.revature.q18;

/**
 * @author Phil
 *
 */
public class ConcreteSubClass implements InterfaceClass {

	/**
	 * Q18:  Write a program having a concrete subclass that inherits three 
	 * 		abstract methods from the superclass.  Provide the following
	 * 		three implementations in the subclass corresponding to the 
	 * 		abstract methods in the superclass:
	 * 
	 * 1) Check for uppercase characters in a String, and return 'true' or 'false'
	 * 		depending if any are found.
	 * 
	 * 2) Convert all of the lowercase characters to uppercase from the input 
	 * 		string, and return the result
	 * 
	 * 3) Convert the input string to integer, add 10 and output the results to the console
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteSubClass csc = new ConcreteSubClass();
		csc.add10("brak");
	}

	/*
	 * returns true if there is a capital letter and false if not
	 * (non-Javadoc)
	 * @see com.revature.q18.InterfaceClass#hasUpper(java.lang.String)
	 */
	@Override
	public boolean hasUpper(String str) {
		boolean b = false;
		StringBuilder sb = new StringBuilder(str);
		
		for (int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				b = true;
				break;
			}
		}
		
		return b;
	}

	/*
	 * returns the passed string with all uppercase characters
	 * (non-Javadoc)
	 * @see com.revature.q18.InterfaceClass#toUpper(java.lang.String)
	 */
	@Override
	public String toUpper(String str) {
		return str.toUpperCase();
	}

	/*
	 * prints out the passed int plus 10
	 * @see com.revature.q18.InterfaceClass#add10(java.lang.String)
	 */
	@Override
	public int add10(String str) {
		int x = 0;
		try {
			x = (Integer.parseInt(str) + 10);
			System.out.println(x);
		}
		catch (NumberFormatException nfe) {
			System.out.println(str + " is in an invalid format (int)");
		}

		return x;  // for JUnit testing
	}
}

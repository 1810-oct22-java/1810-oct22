package com.revature.question18;

import java.util.InputMismatchException;


/**
 * Write a program having a concrete subclass that inherits three abstract methods from a superclass
 * @author thienle
 *
 */
public class Question18 {

	
	
	public static void main(String[] args) {
		
		AllAboutString all = new AllAboutString();
		
		System.out.println(all.checkUppercase("i don't have It"));
		
		System.out.println(all.converttoUppercase("Let do it"));
		
		
		System.out.println(all.parseInt("24.7"));
		
		

	}
	
	
	
}


/**
 * Abstract class with three abstract methods
 * @author thienle
 *
 */
abstract class AbstractString {
	
	public abstract boolean checkUppercase(String str);
	
	abstract String converttoUppercase(String str);
	
	abstract int parseInt(String str);

}


/**
 * class extends AbstractString
 * @author thienle
 *
 */
class AllAboutString extends AbstractString {
	
	/**
	 * Check if Uppercase
	 */
	public boolean checkUppercase(String str) {
		
	    
	    int i = 0;
	    boolean found = false;
	    
	    while(i < str.length() && !found) {
	    	
	    	if(Character.isUpperCase(str.charAt(i))) {
	    		found = true;
	    	}
	    	i++;
	    }
	    
	    return found;
	}
	
	/**
	 * convert to uppercase
	 */
	public String converttoUppercase(String str) {
		
		
		return str.toUpperCase();
	}
	
	/**
	 * Convert the input string to integer and add 10
	 */
	public int parseInt(String str) {
		
		double d = Double.parseDouble(str);
		
		int total = (int) d + 10;
		return total;
	}

}

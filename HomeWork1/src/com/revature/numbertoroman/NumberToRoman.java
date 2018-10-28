package com.revature.numbertoroman;

import java.util.*;

/**
 * Convert number to roman number
 * @author thienle
 *
 */
public class NumberToRoman {
	
	public static void main(String[] args) {
		
		System.out.println(convertNumber(2018));
		
	}

	
		
		
		/**
		 * 
		 * @param number
		 * @return
		 */
	    public static String convertNumber(int number) {
	    	
	    	int [] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

		    String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	        StringBuilder romanNumerals = new StringBuilder();
	        
	        int remainder = number;

	        for (int i=0;i<arabic.length;i++) {

	            while (remainder >= arabic[i]) {
	                romanNumerals.append(roman[i]);
	                remainder -= arabic[i];
	            }
	        }

	        return romanNumerals.toString();
	    }
	

}


	

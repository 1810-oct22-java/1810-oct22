package Question24;

import java.awt.List;
import java.util.ArrayList;

public class ConvertHex {
	
	//Q. 24. Write a method, not using the Integer wrapper class, 
	//	to turn a number in base 10 to hexadecimal
	
	public static void main(String[] args) {
		
//		int dec = 21601122;
//		convertHex(dec);
		
	}

	public String convertHex(int dec) {

		//create array of Hexadecimal values to compare with
		String[] hexVal = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" }; 
		
	    StringBuffer hex = new StringBuffer();
	    
	    //while loop to keep getting remainder until number reaches 0
	    while (dec != 0) {
	    	
	    	//get remainder of number and convert the value based on the element in hexVal
	    	//insert at the beginning of hex each time
	        hex.insert(0, hexVal[dec % 16]);
	        
	        //divide number by 16 
	        dec /= 16;
	    
	    }
		
	    // test print
	    System.out.println(hex.toString());
	    
	    return hex.toString();
	}

}

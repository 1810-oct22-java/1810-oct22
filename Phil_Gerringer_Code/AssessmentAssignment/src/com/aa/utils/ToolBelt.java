/**
 * 
 */
package com.aa.utils;

/**
 * @author Phil
 *
 */
public class ToolBelt {

	// for this project I'll be using the API from api.nasa.gov
	//https://api.nasa.gov/planetary/apod?api_key=EiQQczwSYMLOQF0Tkib6HuXNpYPw0xnknERRLll5
	public final static String API_KEY="EiQQczwSYMLOQF0Tkib6HuXNpYPw0xnknERRLll5";
	public final static String API_URL="https://api.nasa.gov/planetary/apod";
	
	public static Integer[][] spiral(int array_size) {
		int result[][] = new int[array_size][array_size];
		
		// first row
//		1  2  3  4				1 2 3
//		12 13 14 5				8 9 4
//		11 16 15 6				7 6 5
//		10 9  8  7
		
		// total number of entries
		int total = array_size * array_size;
		
		if(total%2 == 0) {
			// is even
		}
		else {
			// is odd
		
			for(int i=total; i > 0; i--) {
				int row = total/array_size;
				int col = total/array_size;
				
				System.out.println(row + "  " + col);
				
				result[row][col] = i;
				
				System.out.println(result.toString());
			}
		}
		
		
		
		
		return null;
	}
}

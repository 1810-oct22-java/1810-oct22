/**
 * 
 */
package com.revature.tools;

/**
 * @author Phil
 *
 */
public class Arguments {

	public static float PHILS_HEIGHT = 5.6f;
	public static float PHILS_AGE = 50;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(validInt("100"));
	}
	
	public static int validInt(String[] args, int std) {
		int clean = std;
		
		// clean up the input data
		if(args.length > 0) {
			clean = Integer.parseInt(args[0]);
		}
		
		return clean;
	}
	
	public static int validInt(String str) {
		int i = Integer.parseInt(str);
		return i;
	}
	
	public static String validString(String[] args, String std) {
		String clean = new String(std);
		
		// clean up the input data
		if(args.length > 0) {
			clean = args[0];
		}
		
		return(clean);
	}

}

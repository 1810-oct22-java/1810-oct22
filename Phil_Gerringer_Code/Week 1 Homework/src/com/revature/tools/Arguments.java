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
		System.out.println(validInt("100"));
	}
	
	public static int validInt(String[] args, int deflt) {
		int clean = deflt;
		
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
	
	public static String validString(String[] args, String deflt) {
		String clean = new String(deflt);
		
		// clean up the input data
		if(args.length > 0) {
			clean = args[0];
		}
		
		return(clean);
	}

}

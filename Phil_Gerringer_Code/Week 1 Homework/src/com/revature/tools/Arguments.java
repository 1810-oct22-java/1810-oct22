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
	
	/**
	 * Validates the argument (only one) is a valid int type and then returns the value.  Uses the 
	 * deflt as a default if no int found.
	 * @param args
	 * @param deflt
	 * @return
	 */
	public static int validInt(String[] args, int deflt) {
		int clean = deflt;
		
		// clean up the input data
		if(args.length > 0) {
			clean = Integer.parseInt(args[0]);
		}
		
		return clean;
	}
	
	/**
	 * Returns a int value from a parsed string
	 * @param str
	 * @return
	 */
	public static int validInt(String str) {
		int i = Integer.parseInt(str);
		return i;
	}
	
	/**
	 * Validates the argument (only one) is a valid String type and then returns the value.  Uses the 
	 * deflt as a default if no String found.
	 * 
	 * @param args
	 * @param deflt
	 * @return
	 */
	public static String validString(String[] args, String deflt) {
		String clean = new String(deflt);
		
		// clean up the input data
		if(args.length > 0) {
			clean = args[0];
		}
		
		return(clean);
	}
}

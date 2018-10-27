package Question5;

public class Substring {
	
	/*Q5. Write a substring method that accepts a string str and an 
	 * integer idx and returns the substring contained between 0 and 
	 * idx-1 inclusive. Do NOT use any of the existing substring methods 
	 * in the String, StringBuilder, or StringBuffer APIs.
	 */
	
	public static void main(String[] args) {
		
		//initialize string str and int idx
//		String str = "apple and banana";
//		int idx = 7;
//		substring(str, idx);
		
	}

	public String substring(String str, int idx) {
		
		//initialize an empty string
		String substr = "";
		
		//get length of string
		int strlen = str.length() - 1;
		
		/*
		 * Validate idx
		 * Print error message if idx is out of bounds
		 */
		
		if(idx > strlen) {
			
			System.out.println("idx is out of bounds, please type in another number.");
			
		}
		
		else {
			
			//Use a for loop to add each char up to and including the char at idx-1 into a new substring
			
			for(int i = 0; i < idx; i++) {
				
				substr += str.charAt(i);
				
			}
			
			
		}
		
		//print to test method
//		System.out.println("Substring between 0 and " + (idx-1) + " is: " + substr);
		
		return substr;
		
	}

}

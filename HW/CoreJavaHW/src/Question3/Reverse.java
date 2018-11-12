package Question3;

public class Reverse {
	
	//Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

	
	public static void main(String[] args) {
		
//		String reversethis = "reverse";
//		ReverseString(reversethis);
//		
		
	}

	public String ReverseString(String reverse) {
		
		String reversed = "";
		
		//get length of string so we can traverse backwards
		//subtract one so we aren't out of bounds based on index
		int strlen = reverse.length() - 1;
		
		for(int i = strlen; i >= 0; i--) {
			
			//add each character starting from the last char into a new string hence creating your reversed string
			reversed += reverse.charAt(i);
			
		}
		
		//print to test method
//		System.out.println("Reversed string: " + reversed);
		
		return reversed;
		
	}

}

package Question16;

public class StringLength {
	
	//Q16. Write a program to display the number of characters for a string input. 
	//The string should be entered as a command line argument using (String [ ] args).
	
	public static void main(String[] args) {
		
		//call method to test
		int inputs = args.length;
		int count = 0;
		
		for(int i = 0; i < inputs; i++) {
			
			for(int j = 0; j < args[i].length(); j++) {
				
				count++;
				
			}
			
		}
		System.out.println(count);
		
	}

}

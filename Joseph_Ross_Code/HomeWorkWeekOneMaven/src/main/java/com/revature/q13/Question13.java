package com.revature.q13;

public class Question13 {

	public static void main(String[] args) {
		Question13 test = new Question13();
		test.printTriangle(4);
	}
	
	public String printTriangle(int n) {
		
		//This method does not take negative numbers
		if(n < 0) return "";
		
		//Stores the final result (will be the same as the console output)
		String result = "";
		
		//Used to create the next line to be printed
		String currentLine = "";
		
		//Used to keep track of last value appended to currentLine
		Boolean lastWasZero = false;
		
		//Loops through n times to print n lines
		for(int x = 1; x <= n; x++) {
			
			//Loops through x times to append x 0's/1's to string
			for(int i = 1; i <= x; i++) {
				
				//Append the character that wasn't just added to currentLine
				currentLine += (lastWasZero) ? " 1" : " 0";
				
				//Switch value of lastWasZero so the character that was just
				//appended is not appended again next
				lastWasZero = !lastWasZero;
			}
			
			//Remove leading space from currentLine
			currentLine = currentLine.substring(1);
			
			//Print currentLine to console (this line will have x 0's/1's)
			System.out.println(currentLine);
	
			//Add the currentLine to the result that gets returned at the end of the method
			result += currentLine + "\n";
			
			//Reset the currentLine so that it will only have (x+1) 0's/1's during the next iteration if there is one
			currentLine = "";
		}
		
		//Return the result (will be identical to the console output)
		return result;
	}
}

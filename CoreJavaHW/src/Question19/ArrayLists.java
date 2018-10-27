package Question19;

import java.util.ArrayList;

public class ArrayLists {
	
	//Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
	//	Add all the even numbers up and display the result. Add all the odd numbers up and 
	//	display the result. Remove the prime numbers from the ArrayList and print out the 
	//  remaining ArrayList.
	
	public static void main(String[] args) {
		
		//create ArrayList
		int i = 1, j = 10;
		displayLists(i, j);
		
	}

	public static void displayLists(int i, int j) {
		
		//initialize an ArrayList full
		ArrayList<Integer> full = new ArrayList<Integer>();
		int even = 0, odd = 0 ;
		
		//Populate ArrayList with integers from i to j
		for(int x = i; x <= j; j++) {
			
			full.add(x);
			
		}
		
		System.out.println("Original ArrayList: " + full.toString());
		
		
		//Loop through ArrayList to check for even and add
		for(int a : full) {
			
			
			//Check if it even (same concept as Q6)
			if (((a / 2) * 2) == a) {
				
				even += a;
				
			}
			
			//If it's not even it's odd
			else {
				
				odd += a;
				
			}
			
		}
		
		//Buggy (Needs fixing)
		//check for prime and remove from full
		int count = 0;
		for(int b = i; b <= j; b++) {
			
			//reset count
			count = 0;
			for(int y = 2; y <= b/2; y++) {
				
				if (b % y == 0) {
				
					count++;
					break;
					
				}
			
			}
			if (count == 0 && b != 1) {
			
				full.remove(b);
				
			}
				
		}
		System.out.println("Total of Even Numbers in ArrayList: " + even);
		System.out.println("Total of Odd Numbers in ArrayList: " + odd);
		System.out.println("ArrayList without Prime Numbers: " + full.toString());
		
		
		
			
	}
	
		
}


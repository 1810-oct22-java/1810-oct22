package Question9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	
	public static void main(String[] args) {
		
		//Initialize 2 numbers from i to j
//		int i = 1, j = 100;
//		
//		//call method
//		checkPrime(i, j);
		
	}

	public ArrayList<Integer> checkPrime(int i, int j) {
		
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		
		int count;
		
		for(int x = i; x <= j; x++) {
			
			//reset count
			count = 0;
			
			//only need to loop through have of x
			//since no number is divisible more than half of itself
			//in the context of prime numbers
			for(int y = 2; y <= x/2; y++) {
				
				//if the value x/y in the list i to j has a remainder of 0
				//increase count and break loop
				if (x % y == 0) {
				
					count++;
					break;
					
				}
			
			}
			
			//check whether or not count is 0 and print prime numbers
			if (count == 0 && x != 1) {
				
				//populate primeNums with every prime number from i to j
				primeNums.add(x);
				System.out.print(x + ",");
				
			}
				
				
		}
		
		return primeNums;
			
	}
		

}

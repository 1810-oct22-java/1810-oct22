/**
 * 
 */
package com.revature.prime;

import java.util.ArrayList;

/**
 * Q9: Create an ArrayList which stores numbers 1 to 100 and prints out all of the
 * 		prime numbers to the console.
 * @author Phil
 *
 */
public class Prime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> base = new ArrayList<Integer>();
		
		//populate the base ArrayList
		for(int i=1; i<=100; i++) {
			base.add(i);
		}
		//System.out.println(base.toString());
		
		// iterate through the list and print out the primes
		for (Integer n: base) {
			if (isPrime(n)) {
				System.out.println(n);
			}
			//System.out.println(n + " prime? " + isPrime(n));
					
		}
	}
	
	/**
	 * Returns true if the int passed in is a Prime number
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		boolean b = true;
		
		// count up to the number to see if there are any multiples 
        for(int i = 2; i <= n-1; i++)
        {
        	// condition for nonprime number
            if(n % i == 0)
            {
                b = false;
                break; // exit the for loop
            }
        }
        
        // final quick check for zero or one - not prime
        if ((n == 0) || (n == 1)) {
        	b = false;
        }
        
        return b;
	}
}

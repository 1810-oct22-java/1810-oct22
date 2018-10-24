/**
 * 
 */
package com.revature.q19;

import java.util.ArrayList;

import com.revature.iseven.IsEven;
import com.revature.prime.Prime;

/**
 * Q19:  Create an ArrayList and insert numbers 1 through 10.  Display the ArrayList.
 * 		 Add all of the even numbers up and display the result.  Add all of the odd 
 * 		 numbers up and display the result.  Remove the prime numbers from the ArrayList
 * 		 and print out the remaining ArrayList.
 * @author Phil
 *
 */
public class Q19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> base = new ArrayList<Integer>();
				
		// Step 1:  populate the base ArrayList
		for(int i=1; i<=10; i++) {
			base.add(i);
		}
		System.out.println("[Base ArrayList] " + base.toString());
				
		// Step 2: Add all of the even numbers and display the result
		// Step 3: Add all of the odd numbers and display the result
		int evenTotals=0;
		int oddTotals=0;
		
		for(Integer n: base) {
			if (IsEven.isEven(n)) {
				evenTotals += n;
			}
			else {
				oddTotals += n;
			}
		}
		System.out.println("[Even Totals] " + evenTotals);
		System.out.println("[Odd Totals] " + oddTotals);
		
		// Step 4: Remove the prime numbers and print out the new ArrayList
		ArrayList<Integer> toRemove = new ArrayList<Integer>();
		for(Integer p: base) {		
			// find the primes and save them
			if (Prime.isPrime(p)) {
				toRemove.add(p);
			}
		}
		// remove the primes
		for (Integer x: toRemove) {
			base.remove(x);
		}
		System.out.println("[No Prime] " + base.toString());
	}

}

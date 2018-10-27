package com.revature.q9;

import java.util.*;

public class q9_Bill {

	public static void main(String[] args) {
		/*
		 Create an ArrayList which stores numbers 
		 from 1 to 100 and prints out all the prime 
		 numbers to the console.
		  */
		int i;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(i = 0; i<100; i++) {
			primes.add(new Integer(i));
			 
		}
		
		 System.out.println("The first 100 prime numbers are \n");
		    printPrimeNumbers(primes.get((i)));
		 //Iterator iter = primes.iterator();
	    //  while (iter.hasNext()) {
		
	//}
		  
		
/*if ((i% 2)==0) //|| (i% 5)==0 || (i % 7)==0 || (i % 11)==0) 
           {
				primes.remove(primes.get(i));
			
			}else if((i% 3)==0&& (i >=7 )) {
				primes.remove(primes.get(i));
			}
else {
				primes.add(new Integer(i));
				System.out.println(primes.get(i));
			}
	}
			
		}*/
	//	for(int i = 0; i<101; i++) {
	  // if  ((primes.get(i) % 2)==0) { primes.remove(i); continue;}
	 //  else if  ((primes.get(i) % 3)==0) {primes.remove(i); continue;} 
	 //  else if  ((primes.get(i) % 5)==0) { primes.remove(i); continue;}
	 //  else if  ((primes.get(i) % 7)==0) { primes.remove(i); continue;}
	 //  else if  ((primes.get(i) % 11)==0) { primes.remove(i); continue;}
	 //  else {     primes.add(primes.get(i));
      //          System.out.println(primes.get(i));
	  // }

	 
		}
	
	  
	 

	  public static void printPrimeNumbers(Integer primes) {
	    final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
	    int count = 0; // Count the number of prime numbers
	    int number = 2; // A number to be tested for primeness

	    // Repeatedly find prime numbers
	    while (count < primes) {
	      // Print the prime number and increase the count
	      if (isPrime(number)) {
	        count++; // Increase the count
              if (count >= 100) {break;}
	        if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
	          // Print the number and advance to the new line
	          System.out.printf("%-5s\n", number);
	        }
	        else
	          System.out.printf("%-5s", number);
	      }

	      // Check if the next number is prime
	      number++;
	    }
	  }

	  /** Check whether number is prime */
	  public static boolean isPrime(int number) {
	    for (int divisor = 2; divisor <= number / 2; divisor++) {
	      if (number % divisor == 0) { // If true, number is not prime
	        return false; // number is not a prime
	      }
	    }
	    return true; // number is prime
	  }
	}






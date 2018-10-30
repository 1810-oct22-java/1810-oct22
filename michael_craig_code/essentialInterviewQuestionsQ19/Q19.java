package essentialInterviewQuestionsQ19;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		ArrayList<Integer> arrNoPrimes = new ArrayList<Integer>();
		int evens = 0;
		int odds = 0;
		for (int i = 1; i < 11; i++) {
			arrL.add(i);
			if (i % 2 == 0) {
				evens += i;
			} else {
				odds += i;
			}
			if (i % 2 == 0 || i % 3 == 0) {
				arrNoPrimes.add(i);
			}
		}
		System.out.println("Complete ArrayList: " + arrL);
		System.out.println("Sum of even numbers " + evens);
		System.out.println("Sum of odd numbers: " + odds);
		System.out.println("Array without primes: " + arrNoPrimes);
	}

}

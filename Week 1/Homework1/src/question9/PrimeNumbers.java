package question9;

import java.util.ArrayList;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(new Integer(i));
			if(pn.checkPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public Boolean checkPrime(int num) {
		for(int i = 2; i <= num/2; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
}

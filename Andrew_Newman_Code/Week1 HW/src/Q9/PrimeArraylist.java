package Q9;

import java.util.ArrayList;

public class PrimeArraylist {

	public static void main(String[] args) {
		ArrayList<Integer> Numbers = new ArrayList<>();
		
		for(int i=1;i<101;i++) {
			Numbers.add(i);
			boolean isPrime = true;
			for(int j=2;j<i;j++) {
				if(i % j == 0) {
					isPrime = false;
				}
			}
	
			if (isPrime == true) {
				System.out.print(i + " ");
			}
		}
	}
}

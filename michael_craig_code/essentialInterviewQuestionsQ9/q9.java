package essentialInterviewQuestionsQ9;

import java.util.TreeSet;

public class q9 {

	public static void main(String[] args) {
		primes();
	}

	static int primes() {
		TreeSet<Integer> arr = new TreeSet<Integer>();
		for (int i = 1; i < 101; i++) {
			int x = 0;
			for (int j = i; j >= 1; j--) {
				if (i % j == 0) {
					x += 1;
				} 
			}
			if (x == 2) {
//				System.out.println(i);
				arr.add(i);
			}
		}
		System.out.println("primes are: " + arr);
		return 0;
	}

}

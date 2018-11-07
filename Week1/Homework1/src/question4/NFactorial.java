package question4;

public class NFactorial {
	public static void main(String[] args) {
		NFactorial nf = new NFactorial();
		System.out.println(nf.factorialize(5));
	}
	
	public int factorialize(int n) {
		int total = 1;
		for(int i = 1; i <= n; i++) {
			total *= i;
		}
		return total;
	}
}

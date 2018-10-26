package Q2;

public class Fibonacci {

	public static void main(String[] args) {
		int num = 25;
		int previous1 = 0;
		int previous2 = 0;
		int current = 0;
		
		for(int i = 0; i<=num;i++) {
			if (current == 0) {
				System.out.print(current + " ");
				current = 1;
				previous1 = 1;
				previous2 = 0;
			}else {
				System.out.print(current + " ");
				current = previous1 + previous2;
				previous2 = previous1;
				previous1 = current;
			}
		}
	}
}

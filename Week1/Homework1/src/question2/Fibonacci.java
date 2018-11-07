package question2;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fib = new Fibonacci();
		fib.fibonacci();
	}
	
	public int[] fibonacci() {
		int[] numbers = new int[27];
		numbers[0] = 0;
		numbers[1] = 1;
		for(int i = 0; i < 25; i++) {
			System.out.println(numbers[i]);
			numbers[i+2] = numbers[i] + numbers[i+1];
		}
		return numbers;
	}

}

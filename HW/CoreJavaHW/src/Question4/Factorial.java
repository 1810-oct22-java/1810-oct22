package Question4;

public class Factorial {

	//Q4. Write a program to compute N factorial.
	
	public static void main(String[] args) {
		
		//declare a number N to be computed in your method
//		int N = 10;
//		compute(N);
		
	}

	public int compute(int N) {
		
		int factorial = 1;
		
		
		//compute the factorial in a loop starting from 1 until it reach N
		//Ex: N = 10 => 10*9*8*7*6*5*4*3*2*1 = 720
		
		for(int i = 1; i <= N; i++) {
			
			factorial *= i;
			
		}
		
		//print to test method
//		System.out.println("Factorial of " + N + ": " + factorial);
		
		return factorial;
		
	}
}

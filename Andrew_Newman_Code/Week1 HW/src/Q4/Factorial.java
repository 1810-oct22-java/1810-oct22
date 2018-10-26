package Q4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		interact();
	}
	
	static void interact() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number");
		
		try {
			int input = scanner.nextInt();
			System.out.println("Factorial of "+input+" is: " + Fact(input));
		} catch (InputMismatchException ime) {
			System.out.println("Input must be an integer.");
			interact();
		}
	}
	
	static int Fact(int Num) {
		if (Num == 1) {
			return(1);
		}
		return (Num * Fact(Num-1));
	}
}

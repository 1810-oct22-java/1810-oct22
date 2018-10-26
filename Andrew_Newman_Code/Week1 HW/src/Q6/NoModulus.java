package Q6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NoModulus {

	public static void main(String[] args) {
		interact();
	}
	
	static void interact() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number");
		
		try {
			int input = scanner.nextInt();
			System.out.println(isEven(input)? "Number is Even" : "Number is Odd");
		} catch (InputMismatchException ime) {
			System.out.println("Input must be an integer.");
			interact();
		}
	}
	
	static boolean isEven(int num) {
		return num==((num/2)*2) ? true : false;
	}
}

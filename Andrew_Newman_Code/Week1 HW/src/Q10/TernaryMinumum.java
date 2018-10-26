package Q10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TernaryMinumum {

	public static void main(String[] args) {
		interact();
	}
	
	static void interact() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter two numbers");
		
		try {
			String input = scanner.nextLine();
			
			String[] splitInput = input.split(" ");
			int num1 = Integer.parseInt(splitInput[0]);
			int num2 = Integer.parseInt(splitInput[1]);
			
			System.out.println(num1 > num2 ? num2 + " is the minumum value": num1 + " is the minumum value");
		} catch (InputMismatchException ime) {
			System.out.println("Input must be an integer.");
			interact();
		}
	}
}

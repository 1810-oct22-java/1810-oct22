package Q5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubStrings {

	public static void main(String[] args) {
		interact();
	}
	
	static void interact() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a string");
		String inputString = scanner.nextLine();
		
		System.out.println("Enter a number");
		int inputNum = 0;
		
		try {
			inputNum = scanner.nextInt();
			System.out.println();
		} catch (InputMismatchException ime) {
			System.out.println();
			interact();
		}
		
		StringBuilder sb = new StringBuilder("inputString");
		StringBuilder newSb = new StringBuilder();
		
		for(int i = 0; i<=inputNum-1; i++) {
			newSb.append(sb.charAt(i));
		}
		
		System.out.println("Original String: " + sb);
		System.out.println(inputNum + " letter substring: " + newSb);
		
		
	}
}
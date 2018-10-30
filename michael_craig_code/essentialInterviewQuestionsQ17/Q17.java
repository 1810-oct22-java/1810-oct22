package essentialInterviewQuestionsQ17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		simpleInterest();
	}

	static void simpleInterest() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Let's calculate for simple interest!");
			System.out.println("Please enter the principal: ");
			int principal = scanner.nextInt();
			System.out.println("Please enter the rate of interest: ");
			int rate = scanner.nextInt();
			System.out.println("Please enter the number of years: ");
			int time = scanner.nextInt();
			System.out.println("Your simple interest is: " + (principal * rate * time));
		} catch (InputMismatchException e) {
			System.out.println("Try again");
			simpleInterest();
		}
		scanner.close();
	}
}

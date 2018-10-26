package Q14;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		interact();
	}
	
	static void interact() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Choose a case");
		System.out.println("1. Square root");
		System.out.println("2. Today's Date");
		System.out.println("3. Array Split");
		
		try {
			int input = scanner.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Enter a Number");
				int input2 = scanner.nextInt();
				System.out.println(Math.sqrt(input2));
				break;
			case 2:
				System.out.println(Calendar.getInstance().getTime());
				break;
			case 3:
				String output = "I am Learning Core Java";
				String[] outputArray = output.split(" ");
				for(String s : outputArray) {
					System.out.println(s);
				}
				break;
				
			}
		} catch (InputMismatchException ime) {
			System.out.println("Input must be an integer.");
			interact();
		}
	}
}

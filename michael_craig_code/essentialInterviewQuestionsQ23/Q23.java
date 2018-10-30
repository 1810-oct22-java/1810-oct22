package essentialInterviewQuestionsQ23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q23 {

	public static void main(String[] args) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a date using the dd/mm/yyyy format");
		String userDate = scanner.next();
		try {
			Date date = formatter.parse(userDate);
			System.out.println("Reformatted Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("No! Try again ");
			main(args);
		}
		scanner.close();
	}
}

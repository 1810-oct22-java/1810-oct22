package essentialInterviewQuestionsQ14;

import java.util.ArrayList;
import java.util.Date;

public class Q14 {

	public static void main(String[] args) {
		switcher(1, 9);
		switcher(2, 0);
		switcher(3, 0);
	}

	private static void switcher(int x, double num) {

		switch (x) {
		case 1:
			System.out.println("The square root of " + x + " is: " + Math.sqrt(num));
			break;
		case 2:
			Date date = new Date();
			System.out.println("Today's date is: " + date);
			break;
		case 3:
			String[] str = "I am learning Core Java".split(" ");
			ArrayList<String> arr = new ArrayList<String>();
			for (int i = 0; i < str.length; i++) {
				arr.add(str[i]);
			}
			System.out.print(arr);
			break;
		default:
			break;
		}
	}
}

package essentialInterviewQuestionsQ6;

public class q6 {
	
	public static void main(String[] args) {
		isEven(20);
		isEven(21);
	}

	static void isEven (double d) {
		String num = String.valueOf(d / 2);
		if (num.contains(".0")) {
			System.out.println(d + " is an EVEN NUMBER");
		}
		else {
			System.out.println(d + " is an ODD NUMBER");
		}
	}
	
}

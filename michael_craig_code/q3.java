package EssentialInterviewQuestions;

public class q3 {

	public static void main(String[] args) {
		reverse("reversed string");
	}
	
	static void reverse (String x) {
		for (int i = x.length(); i > 0; i--) {
			System.out.print(x.charAt(i - 1));
		}
	}
}

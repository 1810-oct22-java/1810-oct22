package EssentialInterviewQuestions;

public class q21 {

	public static void main(String[] args) {
		removeChars("any repeats?");
		removeChars("beep boop");
	}

	private static void removeChars(String s) {
		String newStr = "";
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			String y = String.valueOf(letter);
			s = s.replace(y, ".");
			if (!s.contains(y)) {
				newStr += y;
			}
		}
		System.out.println("String without repeats: " + newStr);
	}
}

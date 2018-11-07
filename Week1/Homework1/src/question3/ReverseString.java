package question3;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString rs = new ReverseString();
		String needsReversing = "Reverse this!";
		String reversedString = rs.reverse(needsReversing);
		
		System.out.println(reversedString);
	}
	
	public String reverse(String word) {
		String reversedString = "";
		for(int i = 0; i < word.length(); i++) {
			reversedString = reversedString + word.charAt(word.length()-i -1);
		}
		return reversedString;
	}

}

package question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		for(int i = 0; i < words.size(); i++) {
			if(checkPal(words.get(i))) {
				palindromes.add(words.get(i));
			}
		}
		
		for(int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}

	}
	
	static Boolean checkPal(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString().equals(word);
	}

}

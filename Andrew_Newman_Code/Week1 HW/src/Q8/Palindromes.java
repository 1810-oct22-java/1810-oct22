package Q8;

import java.util.ArrayList;


public class Palindromes {

	public static void main(String[] args) {
		String[] arr = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> wordsPal = new ArrayList<String>();
		
		for(String s : arr) {
			words.add(s);
			StringBuilder sb = new StringBuilder(s);
			if(s.equals(sb.reverse().toString())) {
				wordsPal.add(s);
			}
			
		}
		
		for(String s : words) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		for(String s : wordsPal) {
			System.out.print(s + " ");
		}
		
	}
}

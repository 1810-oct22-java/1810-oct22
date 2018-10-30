package essentialInterviewQuestionsQ8;

//import java.util.ArrayList;

public class q8 {
	
	public static void main(String[] args) {
		isPalindrome("radar");
//		isPalindrome();
	}
	
//	static void palindrome(String str) {
//		int x = 12;
//        ArrayList<String> arr = new ArrayList<String>(x); 
//        arr.add("karan");
//        arr.add("madam");
//
//        if (arr.get(0) == arr.get(0).reverse()) {
//        	System.out.println("is palindrome");
//        };
//
//		System.out.println(arr.get(0));
//	}
	
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		boolean reversed = sb.reverse().toString().equals(str);
		System.out.println(reversed);
		return sb.reverse().toString().equals(str);
	}

}

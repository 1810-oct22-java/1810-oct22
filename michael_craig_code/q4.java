package EssentialInterviewQuestions;

//import java.util.ArrayList;

public class q4 {

	public static void main(String[] args) {
		nFactorial(4);
		nFactorial(5);
		nFactorial(10);
	}
	
	static void nFactorial (int x) {
		int num = 0;
		for (int i = 0; i < x; i++) {
			if (num == 0) {
				num = x - i;
			} 
			else {
				num *= x-i;
			}
		}
		System.out.println(num);
	}
	
}

package essentialInterviewQuestionsQ15;

public class Q15 {
	
	public static void main(String[] args) {
		Mathematical mathy = new Mathematical();
		mathy.addition(2, 3);
		mathy.subtraction(23, 1);
		mathy.multiplication(4, 3);
		mathy.division(10, 2);
	}
}

class Mathematical {
	
	public void addition(int x, int y) {
		System.out.println(x + y);
	}

	public void subtraction(int x, int y) {
		System.out.println(x - y);
	}

	public void multiplication(int x, int y) {
		System.out.println(x * y);		
	}

	public void division(int x, int y) {
		System.out.println(x / y);		
	}

}


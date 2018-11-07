package question6;

public class EvenOrOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenOrOdd eoo = new EvenOrOdd();
		if (eoo.determineIfEven(9)) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
		if (eoo.determineIfEven(8)) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}

	public boolean determineIfEven(int num) {

		int q = num / 2;
		if (q * 2 == num) {
			return true;
		} else {
			return false;
		}
	}

}

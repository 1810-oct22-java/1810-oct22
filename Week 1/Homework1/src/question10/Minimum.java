package question10;

public class Minimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minimum m = new Minimum();
		System.out.println(m.findMinOfTwo(43,50));
		System.out.println(m.findMinOfTwo(90,2));
		System.out.println(m.findMinOfTwo(4,4));
	}

	public int findMinOfTwo(int x1, int x2) {
		return x1 < x2 ? x1 : x2;
	}
}

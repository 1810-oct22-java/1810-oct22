package question13;

public class TrianglePrinter {

	public static void main(String[] args) {
		
		
		String trianglePart1 = "0";
		String trianglePart2 = "1 0";
		String trianglePart3 = "1 0 1";
		String trianglePart4 = "0 1 0 1";
		String[] triangle = {trianglePart1, trianglePart2, trianglePart3, trianglePart4};
		for(int i = 0; i < 4; i++) {
			System.out.println(triangle[i]);
		}
		

	}

}

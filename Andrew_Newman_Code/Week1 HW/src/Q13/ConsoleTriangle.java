package Q13;

public class ConsoleTriangle {

	public static void main(String[] args) {
		boolean isZero = true;
		for(int i = 1; i<5;i++) {
			for(int j = 1;j<=i;j++) {
				if(isZero) {
					System.out.print("0 ");
					isZero = false;
				}else {
					System.out.print("1 ");
					isZero = true;
				}
			}
			System.out.println();
		}
	}
}

package Q12;

public class EnhancedForLoop {

	public static void main(String[] args) {
		int[] numArray = new int[100];
		for(int i = 1;i<101;i++) {
			numArray[i-1] = i;
		}
		
		for(int num : numArray) {
			if(num%2 == 0) {
				System.out.print(num + " ");
			}
				
		}
	}
}

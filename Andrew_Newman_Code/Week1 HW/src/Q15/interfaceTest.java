package Q15;

public class interfaceTest {

	public static void main(String[] args) {
		int operA = 6;
		int operB = 3;
	
		Interfaces Inter = new Interfaces();
		
		System.out.println(Inter.addition(operA, operB));
		System.out.println(Inter.subtraction(operA, operB));
		System.out.println(Inter.multiplication(operA, operB));
		System.out.println(Inter.division(operA, operB));
		
	}
}

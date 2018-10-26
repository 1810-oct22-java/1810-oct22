package Q16;

public class CharacterCount {
	

	public static void main(String[] args) {
		try {
			System.out.println(args[0]);
			System.out.println(args[0].length());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please Enter a CL argument to use functionality");
		}
	}
}

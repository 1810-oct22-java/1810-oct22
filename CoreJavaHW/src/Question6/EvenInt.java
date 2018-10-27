package Question6;

public class EvenInt {
	
	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	
	public static void main(String[] args) {
		
		//initialize an int
//		int num = 23;
//		
//		//call method
//		isEven(num);
		
	}

	public boolean isEven(int num) {
		
		//declare a boolean to return
		boolean even = false;
		
		/*
		 * To check if a number is even, the remainder must be 0.
		 * Or the quotient of the number/2 multiplied by 2 must 
		 * equal the number.
		 * 
		 * Ex: 30/2 = 15
		 *     15*2 = 30 
		 */
		
		if (((num / 2) * 2) == num) {
			
			//test print
//			System.out.println("True");
			even = true;
			
		}
		
		else {
			
			//test print
//			System.out.println("False");
			even = false;
			
		}
		
		return even;
	}

}

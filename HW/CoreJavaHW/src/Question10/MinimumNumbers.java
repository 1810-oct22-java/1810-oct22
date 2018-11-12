package Question10;

public class MinimumNumbers {
	
	//Q10. Find the minimum of two numbers using ternary operators.
	//initialize 2 numbers
	public static void main(String[] args) {
		
//		int num1 = 10;
//		int num2 = 20;
//
//		findMin(nu m1, num2);
		
	}

	public int findMin(int num1, int num2) {
		
		int min = num1;
		
		//input validation; check if the parameters are ints
		
		try {
			//ternary operators
			//variable min = (expression) ? value if true: value if false
			
			//if num1 is greater than num2, the minimum is num2 otherwise
			//the minimum is num1
			
			min = (num1 > num2) ? num2: num1;

			
		} catch(Exception e) {  
		
			System.out.print("Type a Number, Not String");               
		
		}
		
		//test print
//		System.out.println("Minimum number between " + num1 + " and " + num2 + " is " + min);
		
		return min;
		
	}
	
	
	
}

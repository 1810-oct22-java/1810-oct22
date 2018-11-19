package question12;

public class EvenNumbers {

	public static void main(String[] args) {
		EvenNumbers en = new EvenNumbers();
		int[] numbers = new int[100];
		for(int i = 0; i < 100; i++) {
			numbers[i] = i+1;
		}
		
		for (int num : numbers) {
			if(en.checkEven(num)) {
				System.out.println(num);
			}
		}

	}
	
	public boolean checkEven(int num) {
		return (num%2==0);
	}

}

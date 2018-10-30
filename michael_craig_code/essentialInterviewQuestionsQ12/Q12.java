package essentialInterviewQuestionsQ12;

public class Q12 {
	public static void main(String[] args) {
		int[] arr = new int[101];
		for (int i = 0; i <= 100; i++) {
			arr[i] = i;
		}
		printNums(arr);
	}

	private static void printNums(int[] arr) {
		for (int num : arr) {
			if (num % 2 == 0) {
				System.out.print(num + " ");							
			}
		}
	}
}

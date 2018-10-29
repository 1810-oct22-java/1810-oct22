package EssentialInterviewQuestions;

public class q1 {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	static void bubbleSort(int arr[]) {

		int leng = arr.length;

		for (int i = 0; i < leng - 1; i++) {
			for (int j = 0; j < leng - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int x = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = x;
				}
			}
		}
	}
}

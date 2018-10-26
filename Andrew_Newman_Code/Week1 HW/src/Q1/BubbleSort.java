package Q1;

public class BubbleSort {
	
	public static void main(String[] args) {
	
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		int temp = 0;
		for(int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		for(int j =0;j<9;j++) {
			for(int i = 0;i<10;i++) {
				if(array[i] > array[i+1]) {
					temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
				}
			}				
		}
		
		for(int x : array) {
			System.out.print(x + " ");
		}
		
		
	}
}

package question1;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bs = new BubbleSort();
		int[] unsorted = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted = bs.sortArr(unsorted);
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
	}
	
	public int[] sortArr(int[] unsorted) {
		for(int i = 0; i < unsorted.length -1; i++) {
			for(int j = 0; j < unsorted.length -1; j++) {
				if(unsorted[j] > unsorted[j+1]) {
					int temp = unsorted[j+1];
					unsorted[j+1] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}
		return unsorted;
		
	}

}

package com.revature.q1;

public class Bubblesort {

	public static void main(String[] args) {
		
		int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		//iterates each number in the array
		for(int i = 0; i < arr.length; i++) {
			
			//iterates through the array that needs to be sorted
			for(int j = 0; j < arr.length - i - 1; j++) {
				
				//switches the numbers if previous number is larger
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
				
			}
			
		}
		
		//iterates through the sorted array and prints
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
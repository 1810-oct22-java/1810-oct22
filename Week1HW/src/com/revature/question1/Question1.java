package com.revature.question1;

import java.util.Arrays;

public class Question1 {
	
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		arr=bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] bubbleSort(int[] arr) {
		Boolean t = false;
		while (t == false) {
			t = true;
			for (int i = 0; i<arr.length-1; i++) {
				int tmp;
				if (arr[i]>arr[i+1]) {
					tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					t = false;
				}
			}
		}
		return arr;
	}
	

}

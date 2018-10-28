package com.revature.bubblesort;

import java.util.Arrays;
import java.util.Random;


/**
 * 
 * @author thienle
 * Bubble sort
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		
		//Generate random array
		//int[] a = ArrayUtil.randomIntArray(10, 100);
		
		int[] a = {1,0,5,6,3,2,3,7,9,8,4};

		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	/**
	 * function to sort an unordered array
	 * @param a
	 */
	public static void sort(int[] a) {
		
		int length = a.length;
		
		for(int i = 0; i < length - 1; i++) {
			
			for (int j = i + 1; j < length; j++) {
				if(a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
		
	}
	
	
	/**
	 * function to swap 2 indexes in an array
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}


/**
 * This class to generate a random array
 * @author thienle
 *
 */
class ArrayUtil {
	
	private static Random gen = new Random();
	
	
	public static int[] randomIntArray(int length, int n) {
		
		int[] a = new int[length];
		
		for(int i = 0; i < length; i++) {
			a[i] = gen.nextInt(n);
		}
		
		return a;
	}

}

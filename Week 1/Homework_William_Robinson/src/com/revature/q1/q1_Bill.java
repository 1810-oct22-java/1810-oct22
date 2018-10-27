package com.revature.q1;

public class q1_Bill {

	  public static void bubbleSort(int[] list) {
		    boolean needNextPass = true;
		    
		    for (int k = 1; k < list.length && needNextPass; k++) {
		      // Array may be sorted and next pass not needed
		      needNextPass = false;
		      for (int i = 0; i < list.length - k; i++) {
		        if (list[i] > list[i + 1]) {
		          // Swap list[i] with list[i + 1]
		          int temp = list[i];
		          list[i] = list[i + 1];
		          list[i + 1] = temp;
		          
		          needNextPass = true; // Next pass still needed
		        }
		      }
		    }
		  }

		  /** A test method */
		  public static void main(String[] args) {
		    int[] list = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		    bubbleSort(list);
		    for (int i = 0; i < list.length; i++)
		      System.out.print(list[i] + " ");
		  }

}

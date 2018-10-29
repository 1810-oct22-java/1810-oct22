package com.HW1.question01;

public class BubbleSort {
	/*
	 * goes to the list, if a number is smaller than the previous one it will switch
	 * the position
	 */
    
    public void bubbleSort(int array[]){
        for(int i = 0; i <(array.length-1); i++){
            for(int j = 0; j < (array.length - i - 1);j++){
                int swap = array[j];
                array[j] = array[j+1];
                array[j+1] = swap;
               }
            }
        }
    public static void main(String[] args) {
        BubbleSort st = new BubbleSort();
        int array[] = {64,34,25,12,22,11,90};
        for(int k = 0; k < array.length; ++k){
            System.out.print(array[k]+ " ");
            }
        }
}

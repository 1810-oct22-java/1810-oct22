package com.revature.q1;

public class Question1 {

	public static void main(String[] args) {
		
		//Create the list
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("List has been created");
		printList(list);
		
		//Init the new list, and store the results of bubbleSort
		int[] sortedList = bubbleSort(list);
		
		System.out.println("Printing sorted list");
		printList(sortedList);

	}
	
	public static int[] bubbleSort(int[] list) {
		
		//This for loop will iterate list.len - 1 times because the final iteration is not necessary
        for (int i = 0; i < list.length - 1; i++) {
        	
        	//This for loop will iterate list.len - i - 1 times because the list[list.len - i - 1] will always be correct
        	for (int x = 0; x < list.length -i - 1; x++) {
        		
        		//We compare every value next to eachother, and swap if necessary
            	if (list[x] > list[x+1]) {
                	
					// Perform the swap between list[j] and list[i], we must use a temp variable to accomplish this
					int temp = list[x]; 
					list[x] = list[x+1]; 
                    list[x+1] = temp; 
                }
            }
        }
        return list;
	}
	
	public static void printList(int[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}

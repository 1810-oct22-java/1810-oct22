package com.revature.triangle;

public class Triangle {
	
	public static void main(String[] args) {
		
		printTriangle(2);
	}
	
	public static void printTriangleRecursive(int sideLength) {
		
		
		
		if(sideLength < 1) return;
		
		printTriangle(sideLength - 1);
		
		for(int i = 0; i < sideLength; i++) {
			
			System.out.println("[]");
	
		}
		System.out.println();
	}
	
	public static void printTriangle(int num) {
		
		int count = 0;
		
		for(int row = 0; row < num; row++) {
			
			for(int col = 0; col <= row; col++) {
				
				if(count==0) {
					System.out.print("0 ");
					count++;
				}else {
					System.out.print("1 ");
					count--;
				}
			}
			
			System.out.println();
			
		}
	}

}

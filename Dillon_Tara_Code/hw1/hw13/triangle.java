package com.revature.hw13;

public class triangle {
	
	public static void main(String []args){
        int n=4; 
        for(int i = 0; i <= n; ++i)
        {
           for(int j = 0; j< i; j++)
              System.out.print((i+j) % 2 == 0 ? "0 " : "1 ");

            System.out.print("\n");
        }

     }

}

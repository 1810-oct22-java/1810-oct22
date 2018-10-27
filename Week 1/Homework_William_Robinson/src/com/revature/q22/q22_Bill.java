package com.revature.q22;


public class q22_Bill {

	public static void main(String[] args) {
	/*	Create a functional interface and 
	 * implement it in different ways using 
	 * lambda expressions
*/
		q22_Bill q22 = new q22_Bill();
		
		q22.weld(() -> 
		System.out.println("Underwater welding"));
		
	    q22_Bill q23 = new q22_Bill();
	    
	    q23.weld(() ->
	    System.out.println("Deep space welding"));
	    
	    q22_Bill q24 = new q22_Bill();
	    
	    q24.weld(() ->
	    System.out.println("Aeronautical welding"));
	}
	

	
public void weld(weldTorch weldingType) {
	weldingType.weld();
    }
		
}

interface weldTorch{
	
	void weld();
	
}

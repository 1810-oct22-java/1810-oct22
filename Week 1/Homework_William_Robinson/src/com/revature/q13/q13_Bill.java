package com.revature.q13;

public class q13_Bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*
        Display the triangle on the console as 
        follows using any type of loop. Do NOT 
        use a simple group of print statements to 
        accomplish this.
0
1 0
1 0 1
0 1 0 1
        * */
		// tried different methods here
		int go = 0;
		Integer count = new Integer(4);
		StringBuilder sb = new StringBuilder();
		String s = new String();
		for (int j = 0; j< count; j++) {
			if (j % 2 == 0) {
				j = 0;
	
				
			}else if (j % 3 == 1) {
				j = 1;
		
			} else {
			}
	  if (s.contains(" 0 "+ " 0 ")){
		  s.replace(" 0 " + " 0 ", " 0 ");
	  }
	 
	  go++;
	  // Used breakpoint to pinpoint go increment
	  // and space out pyramid correctly
	  if (go == 2 || go == 4 || go ==7) {
		  System.out.println();
	  }
	  count++;
// when count is greater than 15, enough digits
	  // to build pyramid
			if (count >=15) {
				return;
			}
           System.out.print(" " + j + " ");
	
		}
	
	}

}

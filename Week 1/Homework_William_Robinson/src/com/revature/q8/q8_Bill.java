package com.revature.q8;

import java.util.*;

public class q8_Bill {

	public static void main(String[] args) {
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");
		
		ArrayList<String> newList = new ArrayList<String>();
	
	/*	for(int i = sb.length()-1; i>= 0; i--) {
			
				sb.append(s.charAt(i));
					
		}
		System.out.println(sb);*/			
		StringBuilder sb = new StringBuilder();
		String sf = new String();
		StringBuilder rev = new StringBuilder();
		for(int i = myList.size()-1; i>= 0; i--)
	      {
			
			rev = sb.append(sf.charAt(i));
	      }
		
		for(int i = 0; i< myList.size(); i++) {
			sf = myList.get(i);
			if(sf.equals(rev)) {
				 newList.add(myList.get(i));
				 System.out.println(myList.get(i));
			}else {
				  myList.remove(myList.get(i));
			  }
		}
		
	
				
	
		      
			//  if (sb.append(myList.get(i))==(sbr.append(myList.get(i)).reverse())) {
				 
				 
			  } 
			     /*    StringBuilder sb = new StringBuilder();
			         sb = sb.append(myList.get(i));
			         if (!sb.equals(sb.reverse())) {
			        	 myList.remove(myList.get(i));
		         System.out.println(myList.get(i).toString());
			         } else {
			        	 newList.add(myList.get(i));
			        	 System.out.println(newList.get(i).toString());
			         }*/
			     //  System.out.println(newList.get(i));  
		      
		
	  /*    Iterator iter = myList.iterator();
	      while (iter.hasNext()) {
	    	  StringBuilder sb = new StringBuilder();
	    	  sb.append(myList);
	    	  if (sb != sb.reverse()) {
	    	 myList.remove(iter.hasNext());// iter.hasNext());
	    	     }
	         System.out.println(iter.hasNext());
	      }*/
		
		/*
		 Write a program that stores the following strings 
		 in an ArrayList and saves all the palindromes in 
		 another ArrayList.
         “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, 
         “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
		 */

	}



package com.ex.main;

import com.ex.hashset.HashMapImpl;

public class Driver {

	public static void main(String[] args) {
		
		HashMapImpl test = new HashMapImpl();
		
		
		System.out.println(test);
		
		test.insert("My Key", 56);
		
		test.insert("My Keys", 56);
		
		test.insert("Tou", 34);
		
		System.out.println(test);
		
		test.addBuckets(8, 8);
		
		System.out.println(test);
		
		System.out.println(test.find("Tou"));
	}
	
}

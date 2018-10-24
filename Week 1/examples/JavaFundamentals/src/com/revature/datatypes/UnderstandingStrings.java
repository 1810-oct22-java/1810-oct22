package com.revature.datatypes;

public class UnderstandingStrings {
	
	public static void main(String[] args) {
		String a = "hello";
		String b = new String("hello");
		String c = "hello";
		String d = new String();
		
		
		System.out.println(d.equals(""));
		
		a = a.concat(" world");
		System.out.println(a);
		//a = hello world
		//
		System.out.println(a.startsWith("w"));
		System.out.println(a.charAt(4));
		System.out.println(a.substring(5));
		System.out.println(a.substring(5, 7));
		System.out.println(a.lastIndexOf('l'));
		
		//CANNOT initialize like strings. ie StringBuilder sb = "builder";
		StringBuilder sbuild = new StringBuilder(a);
		sbuild.append(" -- building a string");
		System.out.println(sbuild);
		sbuild.reverse();
		System.out.println(sbuild);
		
		StringBuffer sBuff = new StringBuffer("this is a string buffer");
		
		System.out.println(toBinary(10));
		
	} 
	
	// turn decimal number to binary
	static StringBuilder toBinary(int x) {
		String out = "";
		while(x > 0) {
			out += x%2;
			x/=2;
		}
		StringBuilder sb = new StringBuilder(out);
		return sb.reverse();
	}

}

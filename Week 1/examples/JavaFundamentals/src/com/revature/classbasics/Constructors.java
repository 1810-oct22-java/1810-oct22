package com.revature.classbasics;

public class Constructors {
	
	/*
	 * - A constructor is a special method in Java used to 
	 * CONSTRUCT or create a new instance of the class it 
	 * is found in 
	 * - must have the same name (and spelling) as the class
	 * - does NOT have a return type 
	 * - can be overloaded(there can be multiple constructors
	 * in one class as long as they have different parameter
	 * lists)
	 * - the first line of a constructor, whether implicitly 
	 * or explicitly is ALWAYS a call to another constructor
	 * - if we do not specify, a call to the super class's
	 * constructor is implicit as super();
	 * - we can also explicitly call another constructor
	 * of the same class via this();
	 * 
	 */
	
	public Constructors() {} //no-args constructor.
	//if no constructor is defined, this exists by default. 
	//as soon as a constructor is defined, the default no longer exists
	//Constructors c = new Constructors();
	
	public static void main(String[] args) {
		A c = new C();
		System.out.println(c.me);
	}
}

//remember, you can have as many classes in one source file as you wish
//only one can be public 

class A{
	String me; //I am A
	public A() {
		this("I am A");
		System.out.println("A()");
	}
	
	public A(String me) {
		this.me = me;
	}
	
	
}

class B extends A{
	
//	String me; // I Am B
	
	public B() {
		this("I am B");
		System.out.println("B()");
	}
	
	public B(String me) {
		//super();
		this.me = me;
	}
}

class C extends B{
	
//	String me; //I am C 
	
	public C() {
		this("I am C");
		System.out.println("C()");
	}
	
	public C(String me) {
		//super();
		this.me = me;
	}
}


class D {
	
	/* recursive constructors 
	public D() {
		this();
	} */
	
}
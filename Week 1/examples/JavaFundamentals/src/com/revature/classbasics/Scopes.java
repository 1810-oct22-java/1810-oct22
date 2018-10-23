package com.revature.classbasics;

public class Scopes {
	
	/*
	 * variable scopes refer to the lifetime of accessibility
	 * of a variable 
	 * 
	 * There are 4 scopes 
	 * 
	 * class/static  (vars, methods, nested classes) - accessible 
	 * from outside of the class without an instance
	 * ie. Class.x or Class.method();
	 * 
	 * Regarding static variables, these values are shared throughout
	 * any instances of the class 
	 * class Test{ static int count = 0; }
	 * 
	 * from outside Test:
	 * 
	 * Test c = new Test();
	 * Test c2 = new Test();
	 * c.count = 10;
	 * . then c2.count would also be 10;
	 * 
	 * object/instance - the particular instance of the object's 
	 * state and behavior
	 * Class c = new Class();
	 * c.x; or c.method();
	 * 
	 * 
	 * method/local - parameters for method and any variable 
	 * declared within the method
	 * 
	 * block/loop - any variables defined in curly braces or
	 * in the () before a loop
	 */
	
	int instanceVar;
	static int staticInt;
	static double statDoub;
	static char statChar;
	static float statFloat;
	static boolean statBool;
	static byte statByte;
	static long statLong;
	static short statShort;
	static String statString;
	static Integer statWrapper;
	static Boolean staticBoolean;
	
	
	public static void main(String[] args) {
		int methodScope;
		
		Scopes s = new Scopes();
		
		System.out.println(s.instanceVar);
		System.out.println("int default: " + staticInt);
		System.out.println("double: " + statDoub);
		System.out.println("float: " + statFloat);
		System.out.println("char: " + statChar);
		System.out.println("String: " + statString);
		System.out.println("Integer: " + statWrapper);
		System.out.println("boolean: " + statBool);
		System.out.println("Boolean: " + staticBoolean);
		
		//method and block scope vars must be initialized to use
		//System.out.println(methodScope);
		/*
		 * in order to access an instance method or variable 
		 * from inside of a static method, we must instantiate
		 * the class within the class itself. from there we can 
		 * access its instance fields
		 */
		
		s.testingInstance();
		
	}

	void testingInstance() {
		System.out.println("instance method");
	}
	
	static void testingStatic() {
		
	}
}

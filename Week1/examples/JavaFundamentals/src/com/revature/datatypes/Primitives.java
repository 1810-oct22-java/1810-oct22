package com.revature.datatypes;

public class Primitives {

	int a; 		//number type - 4 bytes 
	boolean b; 	// T/F
	char c; 	//' ' - 2 bytes
	double d; 	//decimal - 8 bytes
	long e;		//large number - 8 bytes
	float f;	//floating decimal - 4 bytes
	short g;	//small numbers - 2 bytes
	byte h;		//1 byte

	//what even is a byte????????
	//1 byte = 8 bits (11111111)

	
	public static void main(String[] args) {

		int x; //declaring x 
		x = 5; //initializing x
		x = 10;//reassigning x

		//int x = 100; //cannot redeclare var in same scope 

		int imRich = 100_000_000;
		//int test = _1__0000_;

		double num = 100_000.00;
		//double test = 100._00;

		boolean namingConventionIsCamelCase = true;
		boolean $works = true;
		boolean is_Good$ = false;

		//CASTING 
		//changing the reference type of your entity(primitive or object)
		int number = 1000000;

		//LARGE->SMALL = EXPLICIT
		short smallNum = (short) number; 

		//SMALL->LARGE = IMPLICIT
		long largeNum = smallNum;




		//WRAPPER CLASSES - classes that give object functinality to primitives
		//can be initialized via boxing or instantiation
		Integer wrapInt = number;
		char ch = 'a';
		Character wrapChar = ch; //boxing char ch into its wrapper class 
		Double wrapDouble = 10.09;
		
		Float wrapFloat = new Float(99.01); //instantiating new object
		float flo = wrapFloat;//unboxing wrapper class value into primitive value
		
		Boolean wrapBool = new Boolean(false);

		//Double testNum = (Double) wrapFloat;
		
		double testD = 10.0;
		float t = (float) testD; //primitive casting is more flexible than object casting
		
		
		System.out.println(Integer.MAX_VALUE); //just one of many things wrapper classes expose
		System.out.println();

		long isLong = 1000000000000000L;
		long lowerCaseL = 1000101010010101l;
		
		
		//BASES
		int base10 = 1012414;
		System.out.println(base10);
		
		//BINARY - 0-1
		int base2 = 0b101;
		int moreBinary = 0B10101;
		System.out.println(base2);
		
		//OCTAL - 0-7
		int base8 = 01274;
		System.out.println(base8);
		
		//HEXADECIMAL - 0-9, a-f
		int base16 = 0x10bc34;
		int morehex = 0XA1bD7;
		System.out.println(base16);
		
		
	}
}

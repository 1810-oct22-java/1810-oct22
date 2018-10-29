package com.revature.q11;

import com.revature.q11A.Question11A;

public class Question11 {
	
	float n1,n2;
	
	public static void main(String[] args) {
		//Print floats extracted from class Question11A in package com.revature.q11A
		System.out.println("First float taken from class in different package: " + Question11A.f1);
		System.out.println("Second float taken from class in different package: " + Question11A.f2);
	}

	public Question11(){
		
		n1 = Question11A.f1;
		n2 = Question11A.f2;
	}

}

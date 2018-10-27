package com.revature.question15;

public class Question15 implements simpleMath {

	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public int division(int a, int b) {
		return a/b;
	}

}

interface simpleMath {
	int addition(int a, int b);
	int subtraction(int a, int b);
	int multiplication(int a, int b);
	int division(int a, int b);
}

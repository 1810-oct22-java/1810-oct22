package com.revature.question25;

public class Question25 {
	
	public static void main(String[] args) {
		int n = 2018;
		String answer = roman(n);
		System.out.println(answer);
	}
	
	public static String roman(int n) {
		String answer = "";
		while (n >= 1000) {
			answer = answer + "M";
			n = n-1000;
		}
		while (n >= 900) {
			answer = answer + "CM";
			n = n-900;
		}
		while (n >= 500) {
			answer = answer + "D";
			n = n-500;
		}
		while (n >= 400) {
			answer = answer + "CD";
			n = n-400;
		}
		while (n >= 100) {
			answer = answer + "C";
			n = n-100;
		}
		while (n >= 90) {
			answer = answer + "XC";
			n = n-90;
		}
		while (n >= 50) {
			answer = answer + "L";
			n = n-50;
		}
		while (n >= 40) {
			answer = answer + "XL";
			n = n-40;
		}
		while (n >= 10) {
			answer = answer + "X";
			n = n-10;
		}
		while (n >= 9) {
			answer = answer + "IX";
			n = n-9;
		}
		while (n >= 5) {
			answer = answer + "V";
			n = n-5;
		}
		while (n >= 4) {
			answer = answer + "IV";
			n = n-4;
		}
		while (n >= 1) {
			answer = answer + "I";
			n = n-1;
		}
		return answer;
		
	}
}

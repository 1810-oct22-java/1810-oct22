package com.revature.question14;

import java.util.Date;
import java.util.Scanner;

//NO JUNIT as the only method has void return
public class Question14 {

	public static void main(String[] args) {
		String method = "string split";
		switchFun(method);
	}

	static void switchFun(String method) {
		switch (method)
		{
		case "root":
			Scanner sc = new Scanner(System.in);
			System.out.println("What number would you like the square root of?");
			double num = sc.nextInt();
			System.out.println(Math.sqrt(num));
			break;
		// code here would be unreachable, won't compile
		case "date":
			System.out.println(new Date());
			break;
		case "string split":
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");
			System.out.print("[");
			for (int i = 0; i < arr.length-1; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println(arr[arr.length-1] + "]");
			break;
		default:
			System.out.println("non applicable");
		}
	}

}

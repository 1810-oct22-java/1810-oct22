package com.ex.first;

import org.springframework.stereotype.Component;

@Component
public class First {
	
	
	public void doThings(String a) {
		System.out.println(a);
	}
	
	public int counter(int n) {
		int sum = 0;
		for(int i = 1; i < n; i++) {
			sum+=i;
		}
		return sum;
	}
	
	public void risky() throws RuntimeException{
		System.out.println("risky business");
		throw new RuntimeException();
	}

}

package com.revature.threads;

public class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(i + ") IN IMPLEMENTS RUNNABLE RUN()");
		}
	}

}

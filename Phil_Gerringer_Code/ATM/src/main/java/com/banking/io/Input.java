package com.banking.io;

import java.util.Scanner;

/**
 * Factory Class specifically for controlling access to a Scanner instance
 * 
 * @author Phil
 *
 */
public class Input {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Returns the previously created Scanner instance
	 * @return
	 */
	static public Scanner getInstance() {
		return scanner;
	}

}

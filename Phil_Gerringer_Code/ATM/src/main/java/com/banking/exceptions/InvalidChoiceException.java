package com.banking.exceptions;

/**
 * Exception thrown when invalid input is entered.
 * 
 * @author Phil
 *
 */
public class InvalidChoiceException extends RuntimeException {
	private static final long serialVersionUID = 710731816316444803L;

	public InvalidChoiceException() {
		super("An Invalid Choice Was Entered");
	}

}
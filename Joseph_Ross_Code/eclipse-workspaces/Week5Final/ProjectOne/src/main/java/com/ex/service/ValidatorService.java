package com.ex.service;

import com.ex.exception.InvalidCharactersException;
import com.ex.exception.EmptyInputStringException;

public class ValidatorService {
	
	public static void checkStringInput(String input) throws InvalidCharactersException, EmptyInputStringException {
		
		if(input.equals(null)) throw new EmptyInputStringException();
		
		String test = input.replaceAll( "[^a-zA-Z0-9 ]" , "" );
		
		if(!test.equals(input)) throw new InvalidCharactersException();
		
		
	}

}

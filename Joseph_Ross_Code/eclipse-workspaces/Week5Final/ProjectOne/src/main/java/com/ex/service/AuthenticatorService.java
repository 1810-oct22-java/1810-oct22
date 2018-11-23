package com.ex.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ex.exception.EmptyInputStringException;
import com.ex.exception.InvalidCharactersException;
import com.ex.exception.InvalidUsernameAndPasswordException;
import com.ex.pojos.User;

import com.ex.dao.UserDao;
import com.ex.service.ValidatorService;

public class AuthenticatorService {
	
	private static Logger logger = Logger.getLogger(AuthenticatorService.class);
	
	public static User checkCreds(HttpServletRequest req) throws InvalidUsernameAndPasswordException, InvalidCharactersException, EmptyInputStringException {
		
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		
		//Throws exceptions if invalid
		ValidatorService.checkStringInput(username);
		ValidatorService.checkStringInput(password);
		
		//Checks input length
		if(username.length() > 50 || password.length() > 50)
			throw new InvalidUsernameAndPasswordException();
		
		
		
		
		return null;
	}

}

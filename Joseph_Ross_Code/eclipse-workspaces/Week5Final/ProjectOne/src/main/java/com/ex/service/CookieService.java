package com.ex.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;



public class CookieService {
	
	public Cookie generateCookie(HttpServletRequest req) {
		
		int random_number = (int)(Math.random() * 1_000_000_000 + 1);
		String clientIP = req.getRemoteAddr();
		
		String uniqueIdentifier = random_number + clientIP;
		String uniqueMD5 = "";
		
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		    md.update(uniqueIdentifier.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter.printHexBinary(digest);
			
			Cookie ck = new Cookie("sessionCookie", null);
			ck.setPath("/users/");
			ck.setDomain(".mydomain.com");
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
	}

}

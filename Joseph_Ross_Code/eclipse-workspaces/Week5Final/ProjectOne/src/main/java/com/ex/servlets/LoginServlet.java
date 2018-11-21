package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.pojos.SessionStatus;
import com.ex.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ex.dao.UserDao;
import com.ex.exception.InvalidUsernameAndPasswordException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = "";
		String password = "";
		
		//Create the session object to be sent to client
		SessionStatus status = new SessionStatus();
		
		//Create the writer for sending response
		PrintWriter writer = resp.getWriter();
		//resp.setContentType("application/json");
		
		//Create the mapper for converting response object to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		//Get the session
		HttpSession session = req.getSession();
		
		//Save the user object (this can be null)
		User user = (User) session.getAttribute("user");
		
		/*
		This could only happen if the client was tampered with
		Because the client checks if a session exists as the
		page is loading is redirects the user if a session exists.
		*/
		if(user != null) {
			
			//Invalidate the session to protect 
			session.invalidate();
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			
		//Else if the client wasn't tampered with...
		} else {
			
			username = (String) req.getParameter("username");
			password = (String) req.getParameter("password");
			
			try {
				//If the credentials are correct and no error is caught store user object in session
				session.setAttribute("user", UserDao.loginAttempt(username, password));
				resp.setStatus(HttpServletResponse.SC_OK);
				writer.write(mapper.writeValueAsString(status));
				
			//Something horrible must have happened
			} catch (SQLException e) {
				//Invalidate session to force user to restart application
				//session.invalidate();
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
			//Wrong username and password
			} catch (InvalidUsernameAndPasswordException e) {
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username and password combination!");
			}
			
		}
		
	}
	
}

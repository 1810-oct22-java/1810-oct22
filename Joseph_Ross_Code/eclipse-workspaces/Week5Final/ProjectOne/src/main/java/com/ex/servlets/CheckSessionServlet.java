package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.pojos.SessionStatus;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ex.pojos.User;

@WebServlet("/checkSession")
public class CheckSessionServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Create the session object to be sent to client
		SessionStatus status = new SessionStatus();
		
		//Create the writer for sending response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		//Create the mapper for converting response object to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		//Get the session
		HttpSession session = req.getSession();
		
		//Save the user object (this can be null)
		User user = (User) session.getAttribute("user");
		
		//If session already exists
		if(user != null) {
			
			//Session exists
			status.setSessionExists(true);
			
			//Set the redirect URL depending on the type of user
			if(user.getRole() == 1) status.setForwardUrl("employee");
			if(user.getRole() == 2) status.setForwardUrl("manager");
		
		//If the session doesn't exist
		} else {
			
			status.setSessionExists(false);
		}
		
		//Convert sessionStatus object to JSON and send it
		writer.write(mapper.writeValueAsString(status));
	}
}

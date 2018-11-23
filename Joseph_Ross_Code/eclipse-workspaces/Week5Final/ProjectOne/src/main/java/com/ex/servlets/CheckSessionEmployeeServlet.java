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
import com.ex.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/checkSessionEmployee")
public class CheckSessionEmployeeServlet extends HttpServlet {
	
private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.trace(req.getRemoteAddr());
		
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
		
		//If session doesn't exists
		if(user == null) {
			
			status.setSessionExists(false);
			status.setForwardUrl("login");
			//Convert sessionStatus object to JSON and send it
			writer.write(mapper.writeValueAsString(status));
		
		//If the session doesn't exist
		} else if(user.getRole() != 1) {
			
			session.invalidate();
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			
		} else {
		
			status.setSessionExists(true);
			//Convert sessionStatus object to JSON and send it
			writer.write(mapper.writeValueAsString(status));
		}
		
	}

}

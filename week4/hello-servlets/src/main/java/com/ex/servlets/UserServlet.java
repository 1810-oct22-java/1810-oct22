package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	static DummyUserService userService = new DummyUserService();
	
	private static Logger logger = Logger.getLogger(UserServlet.class);
	
	//retrieve ALL users as JSON string
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//testing servlet context
		String context = getServletContext().getInitParameter("AppInfo");
		logger.trace("SERVLET CONTEXT IN USERSERVLET: " + context);
		
		List<User> users = userService.getUsers(); //get all users from "persistence"
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users); 
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}

}
package com.p1.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.pojos.Users;
import com.p1.service.UsersService;

@WebServlet("/home")
public class LoadHomeViewsServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(LoadHomeViewsServlet.class);

	static UsersService uService = new UsersService();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> u = uService.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(u);
		logger.trace("FINDING ALL U. JSON: " + json);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}
	
	

}
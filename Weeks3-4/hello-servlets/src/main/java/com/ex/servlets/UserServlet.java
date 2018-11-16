package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	static DummyUserService userService = new DummyUserService();
	
//	private static Logger logger = Logger.getLogger(UserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<User> users = userService.getUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users); //write
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}

}

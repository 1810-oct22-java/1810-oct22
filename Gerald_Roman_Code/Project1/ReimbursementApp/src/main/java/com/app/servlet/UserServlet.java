package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojo.User;
import com.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class UserServlet extends HttpServlet{
	static UserService uservice = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User usr = mapper.readValue(req.getInputStream(), User.class);	
		usr = uservice.findByUsername(usr.getUsername());
		// make a new session need id, role
		//check helloservlet, homeservlet and loginservlet
		//redirect to the right page
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}

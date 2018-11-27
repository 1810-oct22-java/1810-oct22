package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDao;
import com.app.pojo.User;
import com.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loadlogin")
public class UserServlet extends HttpServlet{
	static UserService uservice = new UserService();
	static UserDao uDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ObjectMapper mapper = new ObjectMapper();
		//User usr = mapper.readValue(req.getInputStream(), User.class);		
		//usr = uDao.findByUsername(usr.getUsername());		
		
		// make a new session need id, role
		//check helloservlet, homeservlet and loginservlet
		//redirect to the right page
		req.getRequestDispatcher("partials/login.html").forward(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("partials/login.html").forward(req,resp);
	}
}

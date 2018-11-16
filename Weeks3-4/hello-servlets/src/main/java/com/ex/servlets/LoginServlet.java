package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	static DummyUserService userService = new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//functionality to go back to login.html
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login functionality here
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//consult user service to obtain user with this info
		User user = userService.validateUser(username, password);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(user == null) {
			text += "<h1>Invalid credentials please try again</h1>";
		}
		else {
			//successful login
			text+="<h1>Welcome, " + user.getUsername();
			text+="</h1><br> Your info is " + user.getData();
		}
		// if(user != null), successful login
		// if(suer == null), invalid credentials
		
	}
	
}

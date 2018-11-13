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

/*
 * The following annotation eliminates the need for registering
 * the class as a servlet in the web.xml.
 * The servlet takes parameters as well such as load on startup etc
 * If you do not add any parameters, you can simply add the 
 * url-pattern without a param name in the parenthesis 
 * 
 * Note: do NOT use this AND the xml for the same servlet
 * you can use both for different servlets in the same app. but do not 
 * assign more than one url-pattern to the same servlet 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	static DummyUserService userService = new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// functionality to go back to login.html 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login functionality here:
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//consult user service to obtain User with this info
		User user = userService.validateUser(username, password); 
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(user == null) {
			text+= "<h1>Invalid Credentials! Please Try again!";
			//add a button to go back to login screen?
		}
		else {
			//successful log in 
			text +="<h1>Welcome, " + user.getUsername();
			text += "</h1><br> Your info is " + user.getData();
		}
		
	}

}

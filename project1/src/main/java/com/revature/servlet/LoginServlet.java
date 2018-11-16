package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.Users;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	static UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//functionality to go back to login.html
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//llogin functionality here:
		String username = req.getParameter("username");
		System.out.println(username);
		String password = req.getParameter("password");
		
		//consult user servicce to obtain User with this info
		Users user = userService.validiateUser(username, password);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		if(user == null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
			writer.write("<h1>Invalid Username or Password!</h1>");
			//add a button to go back to login screen?
		}
		else {
			//successful log in 
			//Add user to session
			HttpSession session = req.getSession();
			//will return current session if one exists
			//creates new session and returns it if none exists
			session.setAttribute("user", user);
			//logger.trace("Adding USER TO SESSION: "  + session.getId());
			resp.sendRedirect("home");
			//render home view
			//redirect to home servlet
		}
		

	}

}

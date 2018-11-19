package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.pojos.User;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	private static Logger logger = Logger.getLogger(HomeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//check if user session is available. If so, return home view, if not, redirect back home
		HttpSession session = req.getSession();
		logger.trace("IN HOMESERVLET. SESSION: "+session.getId());
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			//redirect to home page
			resp.sendRedirect("login");
		}
		else {
			String text = "";
			PrintWriter writer = resp.getWriter();
			text += "<h1>Welcome, " + user.getUsername();
			text += "!</h1><br> Your info is " +user.getData();
			writer.write(text);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

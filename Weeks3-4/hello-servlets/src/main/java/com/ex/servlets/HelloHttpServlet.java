package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloHttpServlet extends HttpServlet{

	private static Logger log = Logger.getLogger(HelloHttpServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//User servlets to manipulate form data
		String name = req.getParameter("username");
		//req.getParameter(x); where x is input fields name OR
		//parameter append to URL
		String password = req.getParameter("password");		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "Getting Data from from:"
				+ "<br>Username: " + name
				+ "<br>Password: " + password;
		Enumeration<String> paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			text += "<br>PARAM: " + paramNames.nextElement();
		}
		log.debug("servicing httpservice" + text);
		writer.write(text);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "posting Data from from:"
				+ "<br>Username: " + name
				+ "<br>Password: " + password;
		log.debug("servicing httpservice" + text);
		writer.write(text);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
}

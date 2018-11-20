package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(HelloServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		
		String password = req.getParameter("password");
		String testingWrongParam = req.getParameter("doesntExist");

		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "Getting Data from form:" + "<br>Username: " + name + "<br>Password: " + password
				+ "<br>Wrong parameter: " + testingWrongParam;

		Enumeration<String> paramNames = req.getParameterNames();
		while (paramNames.hasMoreElements()) {
			text += "<br>PARAM: " + paramNames.nextElement();
		}

		log.debug("SERVICING HTTPSERVLET: " + text);
		writer.write(text);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");

		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.write("<h1> POSTING DATA! Welcome, <i> " + name + "</i></h1>");
	}
}
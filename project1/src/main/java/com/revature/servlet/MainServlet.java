package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class MainServlet extends GenericServlet {
	private static Logger log = Logger.getLogger(MainServlet.class);
	
	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("Initializaing Main Servlet");
	}

	@Override
	public void service(ServletRequest req,
			ServletResponse res) throws ServletException, IOException {

		//PrintWriter allows you to write responses
		
		String context = getServletContext().getInitParameter("AppInfo");
		String config = getServletConfig().getInitParameter("secret");
		
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		String text = "<h1>HELLO SERVLETS!</h1>"
				+ "<br>"
				+ "<p> </p>"
				+ "This is a response from the MAINSERVLET"
				+ "<br>"
				+ "<br>ServletContext: " + context
				+ "<br>ServletConfig: " + config;
		writer.write(text); //sends parameter as response body
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log.trace("destroyed");
	}

}

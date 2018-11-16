package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends GenericServlet {
	
	private static Logger log = Logger.getLogger(HelloServlet.class);
	
	static int counter = 0;

	@Override
	public void init() throws ServletException {
		super.init();
		log.trace("initializing hello servlet");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		log.trace("in hello servlet service -- counter: " + ++counter);
		
		//PrintWriter allows you to write responses
		
		String context = getServletContext().getInitParameter("AppInfo");
		
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		String text = "<h1>HELLO SERVLETS</h1>"
				+ "<br>"
				+ "This is a response from the helloservlet"
				+ "<br>"
				+ "<i>Request #" + counter + "</i>"
				+ "<br>ServletContext: " + context;
		writer.write(text); //sends parameter as response body
		}
	
	@Override
	public void destroy() {
		super.destroy();
		log.trace("in hello servlet destroy");
	}
	

}

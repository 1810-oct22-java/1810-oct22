package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoadViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
		
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/Weather-App/home.view":
			System.out.println("AT HOME VIEW");
			return "home";
		case "/Weather-App/weather.view":
			return "weather";
			
		}
		
		return null;
	}

}

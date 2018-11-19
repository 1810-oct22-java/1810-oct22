package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class loadViewsServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(loadViewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resourcepath = "partials/" + process(req, resp) + ".html";
		
		req.getRequestDispatcher(resourcepath).forward(req, resp);
		
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		log.info("Load VIEW" + req.getRequestURI());
		
		switch(req.getRequestURI()) {
			
		case "/SampleApp/info.view":
			return "info";
		
		case "/SampleApp/starwars.view":
			return "starwars";

			
		}
		
		return null;
		
	}

}

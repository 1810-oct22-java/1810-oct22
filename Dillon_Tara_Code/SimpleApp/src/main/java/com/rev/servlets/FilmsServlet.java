package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rev.servlets.FilmsServlet;

@WebServlet("/films")
public class FilmsServlet extends HttpServlet  {
	private static Logger logger = Logger.getLogger(FilmsServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("partials/films.html").forward(req, resp);
		
		
	}
	
	
	

}

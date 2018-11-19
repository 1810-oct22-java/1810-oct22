package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/serve","/catview"})
public class BasicServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "";
		if(req.getRequestURI() .equals("/ConceptApp/serve") ) {
			resourcePath = "partials/start.html";
		}else resourcePath = "partials/catview.html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		/*ObjectMapper mapper = new ObjectMapper();
		Object newObject = mapper.readValue(req.getInputStream(), Object.class);
		HttpSession session = req.getSession();
		session.setAttribute("factID", newObject.);
		
		int id = (int) session.getAttribute("userID");
		int role = (int) session.getAttribute("roleID");
		
		
		
		resourcePath = "partials/catview.html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);*/
	}
}

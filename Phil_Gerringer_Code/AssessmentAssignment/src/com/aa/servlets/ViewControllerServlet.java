package com.aa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewControllerServlet
 */
public class ViewControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resource = "views/" + process(request,response) + ".html";
		System.out.println(resource);
		request.getRequestDispatcher(resource).forward(request, response); 
	}
	
	private String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		switch(request.getRequestURI()) {
		case "/AA/login.view":
			url = "login";
			break;
		case "/AA/summary.view":
			url = "summary";
			break;
		}
		
		return url;
	}
}

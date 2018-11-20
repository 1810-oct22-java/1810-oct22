package com.revature.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) +".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("IN VIEW SERVLET " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/practice-assessment/next.view":
			return "next";
		case "/practice-assessment/features.view":
			return "features";
		case "/practice-assessment/pricing.view":
			return "pricing";
		}
		return null;
	}
}

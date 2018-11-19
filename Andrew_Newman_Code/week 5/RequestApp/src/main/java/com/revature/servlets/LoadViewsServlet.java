package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LoadViewsServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoadViewsServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			log.info("ROLE: " + session.getAttribute("roleID"));
		}
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/RequestApp/home.view":
			return "home";
		case "/RequestApp/reg.view":
			return "createUser";
		case "/RequestApp/managerRequests.view":
			return "Allrequests";
		case "/RequestApp/userRequests.view":
			return "userPast";
		case "/RequestApp/createReq.view":
			return "createReq";	
		case "/RequestApp/pending.view":
			return "PendingRequests";
		case "/RequestApp/approved.view":
			return "ApprovedRequests";
		case "/RequestApp/denied.view":
			return "DeniedRequests";
		}

		return null;
	}

}
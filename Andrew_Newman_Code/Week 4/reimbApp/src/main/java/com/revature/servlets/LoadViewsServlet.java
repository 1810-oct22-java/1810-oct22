package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.SimpleUser;
import com.revature.pojos.User;
import com.revature.service.UserService;

public class LoadViewsServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoadViewsServlet.class);
	static UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + postProcess(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);

	}

	static String postProcess(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		ObjectMapper mapper = new ObjectMapper();
		
		switch(req.getRequestURI()) {
		case "/reimbApp/login.view":
			SimpleUser u = mapper.readValue(req.getInputStream(), SimpleUser.class);
			User AuthUser = userService.validateCreds(u.getUsername(), u.getPassword());
			if(AuthUser == null) {return "loginError";
			}else { 
				HttpSession session = req.getSession();
				session.setAttribute("userID", AuthUser.getUserId());
				session.setAttribute("roleID", AuthUser.getRoleID());
				System.out.println(session.getAttribute("userID"));
				System.out.println(session.getAttribute("roleID"));
				if(AuthUser.getRoleID() == 1) {
					return "manageMain";
				}
				else return "userMain";
			}
		case "/reimbApp/userCreate.view":
			User potential = mapper.readValue(req.getInputStream(), User.class);
			AuthUser = userService.getUserbyUsername(potential.getUserName());
			if(AuthUser == null) {
				userService.insertUser(potential.getFirstName(), potential.getLastName(), potential.getUserName(), potential.getPassword(), potential.getEmail(), potential.getRoleID());
				return "creationSuccess";
			}else { return "userExists";}
		}
		return null;
	}

	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		int role = 0;
		HttpSession session = req.getSession(false);
		if(session != null) {role = (int) session.getAttribute("roleID");}
		System.out.println("role:" + role);
		
		switch (req.getRequestURI()) {
		case "/reimbApp/home.view":
			if(role == 1) return "manageMain";
			else if(role == 2) return "userMain";
			else return "login";
		case "/reimbApp/logout.view":
			return "login";
		case "/reimbApp/reg.view":
			return "createUser";
		case "/reimbApp/input.view":
			return "invalidInput";
		case "/reimbApp/creteReq.view":
			return "createReq";	
		case "/reimbApp/Past.view":
			if(role == 1) return "Allrequests";
			return "userPast";
		}

		return null;
	}

}
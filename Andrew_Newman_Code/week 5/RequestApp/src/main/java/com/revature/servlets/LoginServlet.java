package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.SimpleUser;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoginServlet.class);
	static UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		ObjectMapper mapper = new ObjectMapper();

		SimpleUser u = mapper.readValue(req.getInputStream(), SimpleUser.class);
		User AuthUser = userService.validateCreds(u.getUsername(), u.getPassword());
		if (AuthUser == null) {
			req.getRequestDispatcher("partials/loginError.html").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userID", AuthUser.getUserId());
			session.setAttribute("roleID", AuthUser.getRoleID());
			log.trace("ADDING USER TO SESSION: " + session.getId());

			if (AuthUser.getRoleID() == 1) {
				resp.sendRedirect("partials/manageMain.html");
			} else
				resp.sendRedirect("partials/userMain.html");
		}

	}
}

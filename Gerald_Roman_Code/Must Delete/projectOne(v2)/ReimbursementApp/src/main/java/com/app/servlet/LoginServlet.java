package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.app.pojo.User;
import com.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	static UserService userService = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(req.getInputStream(), User.class);
		User checkUser = userService.validateUser(u.getUsername(), u.getPassword());
		logger.trace("Validating Users" + u);

		if (checkUser == null) {
			req.getRequestDispatcher("partials/error-page.html").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userId", checkUser.getUserId());
			session.setAttribute("roleId", checkUser.getRoleId());
			logger.trace("ADDING USER TO SESSION: " + session.getId());
			resp.sendRedirect("home.view");
//			if(roleId == "1") {	}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("login.html").forward(req, resp);
		req.getRequestDispatcher("login").forward(req, resp);
	}

}

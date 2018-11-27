package com.app.servlet;

import java.io.IOException;
//import java.util.logging.Logger;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.app.pojo.User;
import com.app.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static UserService userService = new UserService();
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		
		User user = userService.validateUser(username,password);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(user == null) {
			req.getRequestDispatcher("error-page.html").forward(req, resp);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("user",user);
			logger.trace("ADDING USER TO SESSION" +session.getId());
			resp.sendRedirect("home");
		}
	}

}

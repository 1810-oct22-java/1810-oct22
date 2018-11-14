package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

/*
 * The following annotation eliminates the need for registering
 * the class as a servlet in the web.xml.
 * The servlet takes parameters as well such as load on startup etc
 * If you do not add any parameters, you can simply add the 
 * url-pattern without a param name in the parenthesis 
 * 
 * Note: do NOT use this AND the xml for the same servlet
 * you can use both for different servlets in the same app. but do not 
 * assign more than one url-pattern to the same servlet 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/*
	 * INTERMEDIATE SERVLET TOPICS: redirects, forwards, sessions
	 * A Servlet may perform either a forward or a redirect operation at 
	 * the end of processing a request. It's important to understand the 
	 * difference between these two cases, in particular with respect 
	 * to browser reloads of web pages
	 * 
	 * FORWARD: a forward is performed internally by the servlet
	 * 	The browser is completely unaware that it has taken place, so 
	 * 		its original URL remains intact
	 * 	Any browser reload of the resulting page will simple repeat 
	 * 		the original request, with the original URL
	 * 
	 * REDIRECT: a redirect is a two step process, where the web app
	 * 	instructs the browser to fetch a second URL, which differs from
	 * 	the original
	 * 	A browser reload of the second URL will not repeat the original 
	 * 		request, but will rather fetch the second URL
	 * 	Redirect is marginally slower than a forward, since it requires 
	 * 		two browser requests, not one
	 * 	Objects placed in the original request scope are not available 
	 * 		to the second request
	 * --> In general, a forward should be used if the operation can be 
	 * 		safely repeated upon a browser reload of the resulting web page; 
	 * 		otherwise, redirect must be used. Typically, if the operation 
	 * 		performs an edit on the datastore, then a redirect, not a forward, 
	 * 		is required. This is simply to avoid the possibility of inadvertently 
	 * 		duplicating an edit to the database.
	 * 
	 */
	
	static DummyUserService userService = new DummyUserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// functionality to go back to login.html 
		// REQUEST DISPATCHER 
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login functionality here:
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//consult user service to obtain User with this info
		User user = userService.validateUser(username, password); 
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(user == null) {
			text+= "<h1>Invalid Credentials! Please Try again!";
			//add a button to go back to login screen?
		}
		else {
			//successful log in 
			text +="<h1>Welcome, " + user.getUsername();
			text += "</h1><br> Your info is " + user.getData();
		}
		
		writer.write(text);
		
	}

}

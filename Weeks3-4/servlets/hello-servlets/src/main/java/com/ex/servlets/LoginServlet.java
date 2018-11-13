package com.ex.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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

}

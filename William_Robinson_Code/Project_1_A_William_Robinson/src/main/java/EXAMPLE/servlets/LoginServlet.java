package EXAMPLE.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EXAMPLE.dao.ErsUserDao;
import EXAMPLE.pojos.ers_user;
import EXAMPLE.service.DummyUserService;

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
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// functionality to go back to login.html 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//login functionality here:
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//consult user service to obtain User with this info
		//ers_user user = userService.validateUser(username, password); 
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		String text = "";
		
		if(ErsUserDao.validate(username, password)) {
		 ers_user eu =	new ers_user();
		 ErsUserDao eud = new ErsUserDao();
		 eu = eud.findByUsername(username);
		 eu.getErs_users_id();
		 eu.getUser_role_id();
		 if (eu.getUser_role_id()==1) {
			 HttpSession session = req.getSession();
			 session.setAttribute(req.getParameter("username"), eu);
		       RequestDispatcher rd=req.getRequestDispatcher("s1");  
		        rd.forward(req,resp); 
		 }else {
			 HttpSession session = req.getSession();
			 session.setAttribute(req.getParameter("username"), eu);
			 RequestDispatcher rd=req.getRequestDispatcher("s2");  
		        rd.forward(req,resp); 
		 }
		}
		else {
				//text+= "<h1>Invalid Credentials! Please Try again!";
				//text+= "<br><input type=\"submit\" value=\"Go Back To Login Page\" class=\"btn btn-warning\">";
				//text+= "\"<a href=login.html \">Back to Log In page! </a>\"";
			writer.print("User name or password is incorrect!");      
			RequestDispatcher dis=req.getRequestDispatcher("login.html");          
		          dis.include(req, resp); 
				//add a button to go back to login screen?
			//successful log in 
		//	text +="<h1>Welcome, " + user.getErs_username();
		//	text += "</h1><br> Your info is " + user.getUser_email();
		}
		
		writer.write(text);
		
	}

}
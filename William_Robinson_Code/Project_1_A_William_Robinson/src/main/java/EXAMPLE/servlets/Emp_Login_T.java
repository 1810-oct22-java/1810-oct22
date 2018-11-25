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
import oracle.net.ns.SessionAtts; 

@WebServlet("/s1")
public class Emp_Login_T extends HttpServlet{
  
	      @Override
		  public void doPost(HttpServletRequest request, HttpServletResponse response)  
	    throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  

	    String username1=request.getParameter("username"); 
	    String password1=request.getParameter("password");
		 ers_user eu =	new ers_user();
		 ErsUserDao eud = new ErsUserDao();
		 eu = eud.findByUsername(username1);
		 eu.getErs_users_id();
		 HttpSession session = request.getSession();
		 session.setAttribute(username1, eu);
		  String username = session.getAttribute(username1).toString();

		  out.println("        "
		  		+ "<!DOCTYPE html>\r\n" + 
		  		"<html lang=\"en\">\r\n" + 
		  		"<head>\r\n" + 
		  		"    <meta charset=\"UTF-8\">\r\n" + 
		  		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
		  		"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
		  		"    <title>Document</title>\r\n" + 
		  		"\r\n" + 
		  		"    \r\n" + 
		  		"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\"\r\n" + 
		  		"    crossorigin=\"anonymous\">\r\n" + 
		  		"\r\n" + 
		  		"<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n" + 
		  		"    crossorigin=\"anonymous\"></script>\r\n" + 
		  		"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\" integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\"\r\n" + 
		  		"    crossorigin=\"anonymous\"></script>\r\n" + 
		  		"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\" integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\"\r\n" + 
		  		"    crossorigin=\"anonymous\"></script>\r\n" + 
		  		"</head>\r\n" + 
		  		"\r\n" + 
		  		"<body>"
		  		+ "<nav class=\"navbar bg-dark navbar-dark\">\r\n" + 
		  		"                <a class=\"navbar-brand\" href=\""+ "\">Submit Reimbursement Request</a>\r\n" + 
		  		"                <button class=\"navbar-toggler collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\" aria-expanded=\"false\">\r\n" + 
		  		"                  <span class=\"navbar-toggler-icon\"></span>\r\n" + 
		  		"                </button>\r\n" + 
		  		"                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\" style=\"\">\r\n" + 
		  		"                  <ul class=\"navbar-nav\">\r\n" + 
		  		"\r\n" + 
		  		"                    <li class=\"nav-item\">\r\n" + 
		  		"                      <a class=\"nav-link\" id=\"e1submit\" href='s5?username="+username1+"'\">Submit Reimbursement Request</a>\r\n" + 
		  		"                    </li>\r\n" + 
		  		"                    <li class=\"nav-item\">\r\n" + 
		  		"                      <a class=\"nav-link\" id=\"e1view\" href='s6?username="+username1+"'\">View Reimbursement Requests</a>\r\n" + 
		  		"                    </li>    \r\n" + 
		  		"                    <li class=\"nav-item\">\r\n" + 
		  		"                      <a class=\"nav-link\" href='logout'\">Logout</a>\r\n" + 
		  		"                    </li>    \r\n" +
		  		"                  </ul>\r\n" + 
		  		"                </div>  \r\n" + 
		  		"              </nav>"
		  		+ "\r\n" + 
		  		"    <script type=\"text/javascript\" src=\"emp.js\"></script>\r\n" + 
		  		"\r\n" + 
		  		"</body>\r\n" + 
		  		"</html>");
		  
/*	   String id = (String) session.getAttribute(id1.toString());
	    String username = (String) session.getAttribute(username1);
	    String password = (String) session.getAttribute(password1);
	    String email = (String) session.getAttribute(email1);
	    String firstname = (String) session.getAttribute(firstname1);
	    String lastname = (String) session.getAttribute(lastname1);
	    String roleid = (String) session.getAttribute(roleid1.toString());
	    
	    switch(roleid){
	    case "1": break;  //  go to employee dashboard
	    case "2": break;  // go to finance manager dashboard
	    default: // go to employee dashboard
	    }
	    
	    out.close();  */
	    }  
	  
	}  


package EXAMPLE.servlets;
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import EXAMPLE.dao.ErsUserDao;
import EXAMPLE.dao.ReimbursementDao;
import EXAMPLE.pojos.ers_reimbursement;
import EXAMPLE.pojos.ers_user;
import oracle.net.ns.SessionAtts;
import EXAMPLE.service.Hash;

@WebServlet("/s9")
public class CreateUserServlet extends HttpServlet{

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException { 
        PrintWriter out=response.getWriter();  
       
	    out.print("<!DOCTYPE html>\r\n" + 

	    		"<html>\r\n" + 
	    		"<head>\r\n" + 
	    		"<meta charset=\"ISO-8859-1\">\r\n" + 
	    		"<title>Welcome To your reimbursement home page</title>\r\n" + 
	    		"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css\" integrity=\"sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb\"\r\n" + 
	    		"        crossorigin=\"anonymous\">\r\n" + 
	    		"\r\n" + 
	    		"    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n" + 
	    		"        crossorigin=\"anonymous\"></script>\r\n" + 
	    		"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\" integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\"\r\n" + 
	    		"        crossorigin=\"anonymous\"></script>\r\n" + 
	    		"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js\" integrity=\"sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ\"\r\n" + 
	    		"        crossorigin=\"anonymous\"></script>\r\n" + 
	    		"</head>\r\n" + 
	    		"<body>\r\n" + 
	            "<h1>New Employee Create Portal</h1>"+
	    		"   <form method=\"post\" action =\"s9\">\r\n" + 
	    		"   <table>  \r\n" + 
	    
	    		
	   			"<tr><td>Username</td><td><input type=\"text\" name=\"username\"/></td></tr>  \r\n" + 
	    		" <tr><td>Password</td><td><input type=\"password\" name=\"password\"/></td></tr>  \r\n" + 
	    		"<tr><td>first name</td><td><input type=\"text\" name=\"firstname\"/></td></tr>  \r\n" +
	    		"<tr><td>last name</td><td><input type=\"text\" name=\"lastname\"/></td></tr>  \r\n" +
	    		"<tr><td>email</td><td><input type=\"email\" name=\"email\"/></td></tr>  \r\n" +
	    		"<tr><td>User Role:</td><td>  \r\n" + 
	    		"<select name=\"type\" style=\"width:150px\">  \r\n" + 
	    		"<option value=1>Employee</option>  \r\n" + 
	    		"<option value=2>Finance Manager</option>  \r\n" + 
	    		"</select>  \r\n" + 
	    		"</td></tr>\r\n" + 
	    		"\r\n" + 
	    		"<tr><td colspan=\"2\"><input type=\"submit\" value=\"Submit Request\"/></td></tr>  \r\n" + 
	    		"</table>  \r\n" + 
	    		"   </form>\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"</div>\r\n" + 
	    		"<!--  replace the inner HTML of this div with various \"partial\" HTML pages\r\n" + 
	    		"in order to produce a single page application -->\r\n" + 
	    		"<div class=\"jumbotron\" id=\"view\">\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"</div>\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"\r\n" + 
	    		"<script src = \"reimb.js\" type=\"text/javascript\"></script>\r\n" + 
	    		"</body>\r\n" + 
	    		"</html>");
	    HttpSession session = request.getSession();
        String username=request.getParameter("username");  
        String password=request.getParameter("password");  
        String firstname=request.getParameter("firstname");  
        String lastname=request.getParameter("lastname"); 
        String email = request.getParameter("email");
        String type=request.getParameter("type");
        int type1 = (int)Integer.parseInt(type);
        ErsUserDao eud = new ErsUserDao();
        ers_user ersu = new ers_user();
        ersu = eud.findByUsername(username);
        if(ersu.getErs_username() == null) {
		 session.setAttribute(username, ersu);
		 
		 Hash hash = new Hash(password);
		password = hash.hashed(password);
		 session.setAttribute(password, ersu);
		 session.setAttribute(firstname, ersu);
		 session.setAttribute(lastname, ersu);
		 session.setAttribute(email, ersu);
		 session.setAttribute(type, ersu);
		 
        	if(type1 ==1) {
            request.getRequestDispatcher("s1?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
        	}
        	else{
	            request.getRequestDispatcher("s2?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
            	}
		 
		// request.getRequestDispatcher("s1?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type1).include(request, response); 
		 
		 return;
        }
        else {
        	 out.print("<h1>Sorry. Username already exists. Please enter a unique Username</h1>");
		 return;
        }
	}

	
	
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	            throws ServletException, IOException { 
		  response.setContentType("text/html"); 
	        PrintWriter out=response.getWriter();
	      
           String username=request.getParameter("username"); 
           String password=request.getParameter("password");
           String firstname=request.getParameter("firstname");  
           String lastname=request.getParameter("lastname"); 
           String email = request.getParameter("email");
           String type=request.getParameter("type");
           int type1 = (int)Integer.parseInt(type);
           ErsUserDao eud = new ErsUserDao();
           ers_user ersu = new ers_user();
           ersu = eud.findByUsername(username);
               
               if(ersu.getErs_username() == null) {
            	   ersu.setErs_username(username);
          		 Hash hash = new Hash(password);
         		password = hash.hashed(password);
       	        ersu.setErs_password(password);
       	        ersu.setUser_first_name(firstname);
       	        ersu.setUser_last_name(lastname);
       	        ersu.setUser_email(email);
       	        ersu.setUser_role_id(type1);
       	        ersu=eud.save(ersu); 
       	        HttpSession session = request.getSession();
       			 session.setAttribute(username, ersu);
       			 session.setAttribute(password, ersu);
       			 session.setAttribute(firstname, ersu);
       			 session.setAttribute(lastname, ersu);
       			 session.setAttribute(email, ersu);
       			 session.setAttribute(type, ersu);
               	out.print("<p>User Created successfully!</p>");
               	if(type1 ==1) {
   	            request.getRequestDispatcher("s1?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
               	}
               	else{
       	            request.getRequestDispatcher("s2?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
                   	}
   	            out.close();
   	        
       			 
       			boolean trye = true;
       		 
       			 while(trye) {
       	        	
                    	if(type1 ==1) {
               	            request.getRequestDispatcher("s1?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
                           	}
                           	else{
                   	            request.getRequestDispatcher("s2?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
                               	}
       	           	return;
       	            
       	            		//+ "s9?username="+username+"&"+"password="+password+"&"+"firstname="+firstname+"&"+"lastname="+lastname+"&"+"email="+email+"&"+"type="+type).include(request, response);  
       	         
       	        // trye = false;
       	      //return;
       	            	
       	        }
       			
       			 
               }else { 
            	   
            	   out.print("<p>Sorry. Username already exists. Please enter a unique Username</p>"); 
   	        	request.getRequestDispatcher("login.html").include(request, response);
   	        	
   	        	out.close(); 
   	        	return;
      
               } 
            		
	            out.println("<h1>Sorry! unable to save record<h1>"); 
   	            request.getRequestDispatcher("login.html").include(request, response); 
   	         out.close(); 
   	            return;
                  
          	      	
	}         
	
}

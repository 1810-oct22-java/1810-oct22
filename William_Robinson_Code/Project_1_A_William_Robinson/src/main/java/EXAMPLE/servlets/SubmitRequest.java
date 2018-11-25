package EXAMPLE.servlets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/s5")
public class SubmitRequest extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException { 
        PrintWriter out=response.getWriter();  
        
	    String n=request.getParameter("username"); 
		 ers_user eu =	new ers_user();
		 ErsUserDao eud = new ErsUserDao();
		 eu = eud.findByUsername(n);
		 eu.setErs_username(n);
		 HttpSession session = request.getSession();
		 session.setAttribute(n, eu);
		  String username = session.getAttribute(n).toString();

		 
	    out.print("<p>Welcome "+n + "</p>");
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
	    		"        <nav class=\"navbar bg-dark navbar-dark\">\r\n" + 
	    		"                <a class=\"navbar-brand\" href=\"\">Submit Reimbursement Request</a>\r\n" + 
	    		"                <button class=\"navbar-toggler collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\" aria-expanded=\"false\">\r\n" + 
	    		"                  <span class=\"navbar-toggler-icon\"></span>\r\n" + 
	    		"                </button>\r\n" + 
	    		"                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\" style=\"\">\r\n" + 
	    		"                  <ul class=\"navbar-nav\">\r\n" + 
	    		"                    <li class=\"nav-item\">\r\n" + 
	    		"                      <a class=\"nav-link\" href='s6?username="+n+"'\">View Reimbursement Requests</a>\r\n" + 
	    		"                    </li>    \r\n" +
		  		"                    <li class=\"nav-item\">\r\n" + 
		  		"                      <a class=\"nav-link\" href='logout'\">Logout</a>\r\n" + 
		  		"                    </li>    \r\n" +
	    		"                  </ul>\r\n" + 
	    		"                </div>  \r\n" + 
	    		"              </nav>" +
	    		"<div class=\"jumbotron\" id=\"idk\">\r\n" + 
	    		"   <form method=\"post\" action =\"s5\">\r\n" + 
	    		"   <table>  \r\n" + 
	    		"   <tr><td><input type=\"hidden\" name=\"username\" value="+ eu.getErs_username() +"> </td></tr>" +"<br>"+ "\r\n" + 
	    		
	    		"<tr><td>Amount:</td><td><input type=\"text\" name=\"amount\"></td></tr>  \r\n" + 
	    		"<tr><td>Description:</td><td><textarea name=\"description\"></textarea><!-- <input type=\"password\" name=\"password\"/> --></td></tr>  \r\n" + 
	    		"<tr><td>Receipt:</td><td><input type=\"file\" name=\"receipt\"></td></tr>  \r\n" + 
	    		"<tr><td>Type:</td><td>  \r\n" + 
	    		"<select name=\"type\" style=\"width:150px\">  \r\n" + 
	    		"<option value=1>lodging</option>  \r\n" + 
	    		"<option value=2>travel</option>  \r\n" + 
	    		"<option value=3>food</option>  \r\n" + 
	    		"<option value=4>other</option>  \r\n" + 
	    		"</select>  \r\n" + 
	    		"</td></tr>\r\n" + 
	    		"\r\n" + 
	    		"<tr><td colspan=\"2\"><input type=\"submit\" id=\"subrequest\" value=\"Submit Request\"/></td></tr>  \r\n" + 
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
	    		"<script src = \"emp.js\" type=\"text/javascript\"></script>\r\n" + 
	    		"</body>\r\n" + 
	    		"</html>");

    }
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	            throws ServletException, IOException { 
		  response.setContentType("text/html"); 
	        PrintWriter out=response.getWriter();
	        String username=request.getParameter("username");  
	        String amount=request.getParameter("amount");  
	        String description=request.getParameter("description");  
	        String receipt=request.getParameter("receipt");  
	        String type=request.getParameter("type");  
	        ReimbursementDao dao = new ReimbursementDao();
	        ErsUserDao eud = new ErsUserDao();
	        ers_user ersu = new ers_user();
	        ers_reimbursement ers=new ers_reimbursement(); 
	        ersu = eud.findByUsername(username);
	        int id = ersu.getErs_users_id();
			 HttpSession session = request.getSession();
			 session.setAttribute(username, ersu);
			  String username1 = session.getAttribute(username).toString();
	        ers.setReimb_author(id); 
	        ers.setReimb_amount(Integer.parseInt(amount));  
	        ers.setReimb_description(description); 
	        ers.setReimb_type_id(new Integer(Integer.parseInt(type)));
	        if (receipt !="") {
	        	File image = new File("C:\\Users\\Owner\\Documents\\"+receipt);
				ers.setReimb_receipt(image);
				ers=dao.save(ers); 
				//out.print("<h1>"+ers.getReimb_receipt().toString()+"</h1>");
	        	} 
	        else {
	        	ers.setReimb_receipt("");
	        	out.print("<h1>You didn't provide a receipt</h1>");
	        	ers=dao.save(ers); 
	        }
			//if (image== null) { image = null; ers.setReimb_receipt(null);}
          //  ers.setReimb_receipt(image);  
	       
	        
	        if(ers!=null){ 
	        	out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("s1").include(request, response);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	  
	    
}

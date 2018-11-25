package EXAMPLE.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EXAMPLE.dao.ReimbursementDao;
import EXAMPLE.pojos.ers_reimbursement;

@WebServlet("/s4")
public class ViewDeniedServlet extends HttpServlet{
	 @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)  
 throws ServletException, IOException {
		  response.setContentType("text/html");  
		  PrintWriter out = response.getWriter();  
		        
		  String username=request.getParameter("username"); 
		  String password1=request.getParameter("password");
		  out.print("Welcome Finance Manager "+username + "<br>"); 
		  out.println("<h1>Denied Employee Reimbursement Requests</h1>");

ReimbursementDao RD = new ReimbursementDao();
  
  List<ers_reimbursement> list=RD.findAll2();  
  out.println("<!DOCTYPE html>\r\n" + 
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
	  		"                <a class=\"navbar-brand\" href=\""+ "\">Approved Reimbursement Requests</a>\r\n" + 
	  		"                <button class=\"navbar-toggler collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\" aria-expanded=\"false\">\r\n" + 
	  		"                  <span class=\"navbar-toggler-icon\"></span>\r\n" + 
	  		"                </button>\r\n" + 
	  		"                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\" style=\"\">\r\n" + 
	  		"                  <ul class=\"navbar-nav\">\r\n" + 
	  		"\r\n" + 
	  		"                    <li class=\"nav-item\">\r\n" + 
	  		"                      <a class=\"nav-link\" id=\"viewapproveddenied\"  href='s2?username="+username+"'\">Approve/Deny Reimbursement Requests</a>\r\n" + 
	  		"                    </li>\r\n" + 
	  		"                    <li class=\"nav-item\">\r\n" + 
	  		"                      <a class=\"nav-link\" id=\"viewapproved\" href='s3?username="+username+"'\">View Approved Employee Reimbursement Requests</a>\r\n" + 
	  		"                    </li>    \r\n" + 
	  		"                    <li class=\"nav-item\">\r\n" + 
	  		"                      <a class=\"nav-link\" href='logout'\">Logout</a>\r\n" + 
	  		"                    </li>    \r\n" +
	  		"                  </ul>\r\n" + 
	  		"                </div>  \r\n" + 
	  		"              </nav>");
  out.print("<table border='1' width='100%'");  
  out.print("<tr><th>Id</th><th>Amount</th><th>Submitted</th><th>Description</th><th>Receipt</th><th>Author</th><th>Status</th><th>Type</th></tr>");  
  for(ers_reimbursement e:list){  
   out.print("<tr><td>"+e.getReimb_id()+"</td>"+"</td><td>"+e.getReimb_amount()+"</td><td>"+e.getReimb_submitted()+"</td><td>"+e.getReimb_description()+"</td><td>"+"<a href='s10?username="+username+"&"+"id="+e.getReimb_id()+"&"+
		   
"receipt="+((e.getReimb_receipt()!= null) ? e.getReimb_receipt()+"'>View</a>" : null+"'></a>")+"</td><td>"+e.getReimb_author()+"</td><td>"+e.getReimb_status_id()+"</td><td>"+e.getReimb_type_id()+"</td> </tr>");  
  }  
  out.println("</table><script type=\"text/javascript\" src=\"reimb.js\"></script> \r\n" + 
  		"</body></html>");  
    
  out.close();  
	 }
}

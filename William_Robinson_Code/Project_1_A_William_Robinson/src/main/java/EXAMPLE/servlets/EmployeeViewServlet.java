package EXAMPLE.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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



@WebServlet("/s6")
public class EmployeeViewServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)   
        throws ServletException, IOException {
	   response.setContentType("text/html");  
    PrintWriter out=response.getWriter(); 

    String username1=request.getParameter("username"); 
    String password1=request.getParameter("password");
    out.print("<p>Welcome "+username1+" </p>");
	 ers_user eu =	new ers_user();
	 ErsUserDao eud = new ErsUserDao();
	 eu = eud.findByUsername(username1);

    ReimbursementDao dao = new ReimbursementDao();
	 List <ers_reimbursement> er =	dao.findAll();
	 er =dao.findByUsername1(username1);
	 
	 out.print("<!DOCTYPE html>\r\n" + 
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
		  		"              </nav>"+
	 		 "<table border='1' width='100%'");  
	  out.print("<tr><th>Id</th><th>Amount</th><th>Submitted</th><th>Description</th><th>Receipt</th><th>Author</th><th>Status</th><th>Type</th></tr>"); 
	  for(ers_reimbursement e:er){  
		   out.print("<tr><td>"+e.getReimb_id()+"</td>"+"</td><td>"+e.getReimb_amount()+"</td><td>"+e.getReimb_submitted()+"</td><td>"+e.getReimb_description()+"</td><td>"+"<a href='s10?username="+username1+"&"+"id="+e.getReimb_id()+"&"+
	  
"receipt="+((e.getReimb_receipt()!= null) ? e.getReimb_receipt()+"'>View</a>" : null+"'></a>")+"</td><td>"+e.getReimb_author()+"</td><td>"+e.getReimb_status_id()+"</td><td>"+e.getReimb_type_id()+"</td><td><a href='s11?username="+username1+"&"+"id="+e.getReimb_id()+"'>Delete</a></td> </tr>");  
		  }  
		  out.print("</table> <script type=\"text/javascript\" src=\"emp.js\"></script>\r\n" + 
		  		"\r\n </body>\r\n" +"</html>");  
		    
		  out.close();
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   resp.setContentType("text/html");  
	    PrintWriter out=resp.getWriter(); 

	    String username1=req.getParameter("username"); 
	    String password1=req.getParameter("password");
	    out.print("<p>Welcome "+username1+" </p>");
		 ers_user eu =	new ers_user();
		 ErsUserDao eud = new ErsUserDao();
		 eu = eud.findByUsername(username1);

	    ReimbursementDao dao = new ReimbursementDao();
		 List <ers_reimbursement> er =	dao.findAll();
		 er =dao.findByUsername1(username1);
		 
		 out.print("<!DOCTYPE html>\r\n" + 
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
			  		"              </nav>"+
		 		 "<table border='1' width='100%'");  
		  out.print("<tr><th>Id</th><th>Amount</th><th>Submitted</th><th>Description</th><th>Receipt</th><th>Author</th><th>Status</th><th>Type</th></tr>"); 
		  for(ers_reimbursement e:er){  
			   out.print("<tr><td>"+e.getReimb_id()+"</td>"+"</td><td>"+e.getReimb_amount()+"</td><td>"+e.getReimb_submitted()+"</td><td>"+e.getReimb_description()+"</td><td>"+"<a href='s10?username="+username1+"&"+"id="+e.getReimb_id()+"&"+
		  
	"receipt="+((e.getReimb_receipt()!= null) ? e.getReimb_receipt()+"'>View</a>" : null+"'></a>")+"</td><td>"+e.getReimb_author()+"</td><td>"+e.getReimb_status_id()+"</td><td>"+e.getReimb_type_id()+"</td><td><a href='s11?username="+username1+"&"+"id="+e.getReimb_id()+"'>Delete</a></td> </tr>");  
			  }  
			  out.print("</table> <script type=\"text/javascript\" src=\"emp.js\"></script>\r\n" + 
			  		"\r\n </body>\r\n" +"</html>");  
			    
			  out.close();
	}

}

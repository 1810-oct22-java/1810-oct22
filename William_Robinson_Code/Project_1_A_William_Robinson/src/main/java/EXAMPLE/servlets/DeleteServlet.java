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

@WebServlet("/s11")
public class DeleteServlet extends HttpServlet{
		protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		          throws ServletException, IOException { 	
		       response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        String username=request.getParameter("username");
		        HttpSession session = request.getSession();
		        String sid=request.getParameter("id");    
		        int id=(int)Integer.parseInt(sid);  
		    ers_user eu = new ers_user();
			ErsUserDao eud = new ErsUserDao();
			eu = eud.findByUsername(username);
			eu.getErs_users_id();
			session.setAttribute(request.getParameter("username"), eu);
			session.setAttribute(request.getParameter("id"), eu);
		ReimbursementDao dao1 = new ReimbursementDao();
		ers_reimbursement ert = new ers_reimbursement();
	    ert = dao1.findById(id);	
		ert.setReimb_id(ert.getReimb_id());	
	 dao1.delete(ert);
		
		
 
	    	out.println("<h6>Reimbursement Request Deleted</h6>");
	        response.sendRedirect("s6?username="+username+"&"+"id="+id);  
 
	      
	    out.close();  
		
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response)   
		          throws ServletException, IOException { 	
		       response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		        String username=request.getParameter("username");
		        String sid=request.getParameter("id"); 
		        HttpSession session = request.getSession();
		        int id=(int)Integer.parseInt(sid);  
		    ers_user eu = new ers_user();
			ErsUserDao eud = new ErsUserDao();
			eu = eud.findByUsername(username);
			eu.getErs_users_id();	
		ReimbursementDao dao1 = new ReimbursementDao();
		ers_reimbursement ert = new ers_reimbursement();
	  ert = dao1.findById(id);	
		session.setAttribute(request.getParameter("username"), eu);
		session.setAttribute(request.getParameter("id"), eu);
		ert.setReimb_id(ert.getReimb_id());	
	 dao1.delete(ert);    
	  	out.println("<h6>Reimbursement Request Deleted</h6>");
	      response.sendRedirect("s6?username="+username+"&"+"id="+id);  
  
	    
	  out.close();  
		
		}
	
	}


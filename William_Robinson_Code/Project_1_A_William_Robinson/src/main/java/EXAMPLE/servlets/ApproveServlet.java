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

@WebServlet("/s7")
public class ApproveServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException { 	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String sid=request.getParameter("id");  
        int id=(int)Integer.parseInt(sid); 
        HttpSession session = request.getSession();
        
		ers_user eu = new ers_user();
		ErsUserDao eud = new ErsUserDao();
		eu = eud.findByUsername(username);
		eu.getErs_users_id();	
	ReimbursementDao dao1 = new ReimbursementDao();
	ers_reimbursement ert = new ers_reimbursement();
    ert = dao1.findById(id);
	ert.setReimb_resolver(eu.getErs_users_id());
	dao1.update1(ert ,ert.getReimb_resolver(), ert.getReimb_id());
	session.setAttribute(request.getParameter("username"), eu);
	session.setAttribute(request.getParameter("id"), eu);
    Object status=dao1.update2(ert,ert.getReimb_resolver(), ert.getReimb_id());  
    if(status !=null){  
    	out.println("<h6>Reimbursement Request Denied</h6>");
        response.sendRedirect("s2?username="+username+"&"+"id="+id);  
    }else{  
        out.println("<h6> Sorry! unable to update record</h6>");  
    }  
      
    out.close();  
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException { 	
	       response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        String username=request.getParameter("username");
	        String sid=request.getParameter("id"); 
	        HttpSession session = request.getSession();
	        
	       // out.println(sid);
	       // out.println(username);
	        int id=(int)Integer.parseInt(sid);  
	    ers_user eu = new ers_user();
		ErsUserDao eud = new ErsUserDao();
		eu = eud.findByUsername(username);
		eu.getErs_users_id();	
	ReimbursementDao dao1 = new ReimbursementDao();
	ers_reimbursement ert = new ers_reimbursement();
  ert = dao1.findById(id);
	ert.setReimb_resolver(eu.getErs_users_id());	
	session.setAttribute(request.getParameter("username"), eu);
	session.setAttribute(request.getParameter("id"), eu);
	
  Object status=dao1.update1(ert,ert.getReimb_resolver(), ert.getReimb_id());  
  if(status !=null){  
  	out.println("<h6>Reimbursement Request Denied</h6>");
      response.sendRedirect("s2?username="+username+"&"+"id="+id);  
  }else{  
      out.println("<h6> Sorry! unable to update record</h6>");  
  }  
    
  out.close();  
	
	}
}

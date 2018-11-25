package EXAMPLE.servlets;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletOutputStream;
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

@WebServlet("/s10")
public class RetrieveImage extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.setContentType("text/html"); 
	String id = req.getParameter("id");
	 String receipt=req.getParameter("receipt");
	   PrintWriter out = resp.getWriter(); 
	
	Blob photo = null;
    Integer.parseInt(id);
  //  InputStream stream;
    ers_reimbursement ers = new ers_reimbursement();
    ers.setReimb_receipt(receipt);
    ReimbursementDao dao = new ReimbursementDao();
   // rset = (ResultSet) 
  
    		try {
    			photo = dao.getImage((int)Integer.parseInt(id));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		 resp.setContentType("image/bmp");
    		 out.println("<html><head></head><body><img>");
    	      InputStream in;
			try {
				in = photo.getBinaryStream();
				int length = (int) photo.length();
			
    	      

    	      int bufferSize = 1024;
    	      byte[] buffer = new byte[bufferSize];
    	      ResultSet rset = null;
    	      InputStream stream = rset.getBinaryStream(1);
    	      ByteArrayOutputStream output = new ByteArrayOutputStream();
    	      int a1 = stream.read();
    	    //  while ((length = in.read(buffer)) != -1) {
    	      //  System.out.println("writing " + length + " bytes");
    	      while (a1 >= 0) {
    	          output.write((char) a1);
    	       // output.write(buffer, 0, length);
    	        a1 = stream.read();
    	      }
    	      Image myImage = Toolkit.getDefaultToolkit().createImage(output.toByteArray());
    	      out.println("</img></body></html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					try {
					in = photo.getBinaryStream();
					
				 in.close();
	    	      out.flush();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			finally {
				
			}
			
    	     
    		
	//try {
	//	stream = rset.getBinaryStream(1);
	 //   ByteArrayOutputStream output = new ByteArrayOutputStream();
	  //  int a1 = stream.read();
	   // while (a1 >= 0) {
	    //  output.write((char) a1);
	     // a1 = stream.read();
	//    }
	    
	//} catch (SQLException e) {
		//e.printStackTrace();
		out.print("<h1>No receipt provided by employee</h1>");
	}finally {}

			}
}
  }
	
	//}


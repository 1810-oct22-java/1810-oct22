package EXAMPLE.Project_1_William_Robinson;
import java.io.IOException;
//import java.util.logging.Logger;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import apache.log4j.Logger;

public class servlets extends GenericServlet{
	//   private static Logger log = Logger.getLogger(HelloServlet.class);
	   
	   static int counter = 0;
	   
	   @Override
	   public void init() throws ServletException{
		   super.init();
		//   log.trace("INITIALIZING HELLO SERVLET");
	   }
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	   @Override
	   public void destroy() {
		   
	   }
	

}

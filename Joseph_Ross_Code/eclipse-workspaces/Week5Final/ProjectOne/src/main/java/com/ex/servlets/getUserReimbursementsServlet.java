package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.dao.UserDao;
import com.ex.pojos.ReimbursementEntry;
import com.ex.pojos.SessionStatus;
import com.ex.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getUserReimbursements")
public class getUserReimbursementsServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.trace(req.getRemoteAddr());
		
		//Create the writer for sending response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		
		//Create the mapper for converting response object to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		//Get the session
		HttpSession session = req.getSession();
		
		//Save the user object (this might be null)
		User user = (User) session.getAttribute("user");
		
		//If session doesn't exists
		if(user == null) {
			
			//The client timed out or client cache was cleared
			session.invalidate();
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		
		//If the client was tampered with
		} else if(user.getRole() != 1) {
			
			session.invalidate();
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			
		} else {
		
			ArrayList<ReimbursementEntry> records;
			try {
				records = UserDao.getAllSubmittedReimburements(user);
				//Convert sessionStatus object to JSON and send it
				writer.write(mapper.writeValueAsString(records));
				
			} catch (SQLException e) {
				
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
			}
		}
		
	}
	
}

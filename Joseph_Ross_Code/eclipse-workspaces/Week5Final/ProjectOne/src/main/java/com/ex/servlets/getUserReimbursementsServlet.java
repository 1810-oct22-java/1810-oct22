package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.dao.UserDao;
import com.ex.exception.EmptyInputStringException;
import com.ex.exception.InvalidCharactersException;
import com.ex.exception.InvalidUsernameAndPasswordException;
import com.ex.pojos.ReimbursementEntry;
import com.ex.pojos.ReimbursementList;
import com.ex.pojos.SessionStatus;
import com.ex.pojos.User;
import com.ex.service.AuthenticatorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@WebServlet("/getEmployeeReimbursementRecords")
public class getUserReimbursementsServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.trace("working");
		
		try {
			User user = (User) AuthenticatorService.checkCreds(req);
			
			//Create the writer for sending response
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			
			//Create the mapper for converting response object to JSON
			ObjectMapper mapper = new ObjectMapper();
			
			Gson gson = new Gson();
			
			ArrayList<ReimbursementEntry> records = UserDao.getAllSubmittedReimburements(user);
			
			for(int i = 0; i < records.size(); i++) {
				
			}
			
			logger.trace(mapper.writeValueAsString(list));
			
			writer.write("[");
			writer.write(mapper.writeValueAsString(user));
			writer.write(",");
			writer.write(mapper.writeValueAsString(user));
			writer.write("]");
			
		} catch (InvalidUsernameAndPasswordException e) {
			
			//401 means bad login info
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Credentials");
			
		} catch (InvalidCharactersException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
			
		} catch (EmptyInputStringException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
		
		} catch (SQLException e) {
			
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unknown error occurred");
		}
		
	}	
}

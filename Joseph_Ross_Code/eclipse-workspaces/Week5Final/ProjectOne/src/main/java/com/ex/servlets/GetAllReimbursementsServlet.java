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

import com.ex.dao.UserDao;
import com.ex.exception.EmptyInputStringException;
import com.ex.exception.InvalidCharactersException;
import com.ex.exception.InvalidStringInputException;
import com.ex.exception.InvalidUsernameAndPasswordException;
import com.ex.exception.UserNotAuthorizedForThisRequestException;
import com.ex.pojos.ReimbursementEntry;
import com.ex.pojos.User;
import com.ex.service.AuthenticatorService;
import com.ex.service.SubmitReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getAllReimbursementsServlet")
public class GetAllReimbursementsServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			User user = AuthenticatorService.checkCreds(req);
			
			ArrayList<ReimbursementEntry> records = UserDao.getAllReimburements(user);
			
			//Create the writer for sending response
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			
			//Create the mapper for converting response object to JSON
			ObjectMapper mapper = new ObjectMapper();
			
			//Convert the array list to JSON and send it to client
			writer.write("[");
			writer.write(mapper.writeValueAsString(records.get(0)));
			for(int i = 1; i < records.size(); i++) {
				writer.write(",");
				writer.write(mapper.writeValueAsString(records.get(i)));
			}
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
			
			//Unknown Database Error
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
		} catch (InvalidStringInputException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
		
		} catch (UserNotAuthorizedForThisRequestException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
		
		}
	}

}

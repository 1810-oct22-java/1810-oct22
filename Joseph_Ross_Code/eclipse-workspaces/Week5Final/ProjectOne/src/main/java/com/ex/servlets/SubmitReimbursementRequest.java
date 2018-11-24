package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.exception.EmptyInputStringException;
import com.ex.exception.InvalidCharactersException;
import com.ex.exception.InvalidDollarAmountException;
import com.ex.exception.InvalidStringInputException;
import com.ex.exception.InvalidTypeException;
import com.ex.exception.InvalidUsernameAndPasswordException;
import com.ex.pojos.User;
import com.ex.service.AuthenticatorService;
import com.ex.service.SubmitReimbursementService;

@WebServlet("/submitReimbursementRequest")
public class SubmitReimbursementRequest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			User user = (User) AuthenticatorService.checkCreds(req);
			
			SubmitReimbursementService.submitReimbursement(user, req);
			
			//Everything went good
			resp.setStatus(HttpServletResponse.SC_OK);
			
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
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unknown error occurred");
			
		} catch (InvalidStringInputException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
			
		} catch (InvalidDollarAmountException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
			
		} catch (InvalidTypeException e) {
			
			//Client has been hacked!
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Client has been tampered with!");
			
		}
	}
}

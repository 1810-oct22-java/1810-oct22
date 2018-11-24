package com.ex.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.exception.EmptyInputStringException;
import com.ex.exception.InvalidCharactersException;
import com.ex.exception.InvalidStringInputException;
import com.ex.exception.InvalidUsernameAndPasswordException;
import com.ex.pojos.User;
import com.ex.service.AuthenticatorService;

@WebServlet("/managerReimbursementDecision")
public class ManagerReimbursementDecision extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(GetUserReimbursementsServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			User user = AuthenticatorService.checkCreds(req);
			
			
			
			resp.setStatus(HttpServletResponse.SC_OK);
			
		} catch (InvalidUsernameAndPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCharactersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyInputStringException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStringInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

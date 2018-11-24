package com.p1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.pojos.Reimbursement;
import com.p1.service.ReimbursementService;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(ReimbursementServlet.class);
	
	static ReimbursementService rService = new ReimbursementService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement r = mapper.readValue(req.getInputStream(), Reimbursement.class);
		r = rService.createReimbursement(r.getAuthor(), r.getSubmitted(), r.getResolved(), r.getDescription(), r.getAuthor(), r.getResolver(), r.getStatus_id(), r.getType_id());
		logger.trace("ADDED NEW R " + r);
	}
		
}

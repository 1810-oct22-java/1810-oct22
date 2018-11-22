package com.p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.pojos.Reimbursement;
import com.p1.service.ReimbursementService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{

	private static Logger logger = Logger.getLogger(EmployeeServlet.class);

	static ReimbursementService rService = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> r = rService.getAllRmbs();
		HttpSession session = req.getSession();
		Object sesh = session.getAttribute("user");
		logger.trace(sesh);
		for (Object x : sesh) {
			if () {
				
			}
			logger.trace(x.getAuthor());
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(r);
		logger.trace("FINDING EMP R. JSON: " + json);
		PrintWriter writer = resp.getWriter();		
		resp.setContentType("application/json");
		writer.write(json);
	}
	
}

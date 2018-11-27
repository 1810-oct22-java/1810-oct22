package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.app.pojo.Reimbursement;
import com.app.service.ReimbService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger(ReimbursementServlet.class);
	static ReimbService reimbService = new ReimbService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
		HttpSession session = req.getSession();
		
		LocalDateTime LDT = LocalDateTime.now();
		int ID = reimb.getId();
		int resolver = (int) session.getAttribute("userId");
		int status = reimb.getStatusId();
		
		session.getAttribute("reimbId");
		session.getAttribute("reimbResolved");
		session.getAttribute("reimbResolver");
		session.getAttribute("reimbStatus");
		
		Timestamp resolved = Timestamp.valueOf(LDT);
		
		reimb.setResolved(resolved);
		reimb.setResolver(resolver);
		reimb.setStatusId(status);
		//reimb.getResolved(resolved);
		
		logger.trace("ADDED A NEW REIMB: " + reimb);
		String json = mapper.writeValueAsString(reimb);
		
		//g = gService.addGenre(g.getName());
		//reimb = reimbService.addReimbursement(reimb);
		System.out.println(reimb);
		Reimbursement r = reimbService.addReimbursement(reimb);
		System.out.println(r);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
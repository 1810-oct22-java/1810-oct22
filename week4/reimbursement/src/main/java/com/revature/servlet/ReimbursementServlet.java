package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Reimbursement;
import com.revature.service.ReimbursementService;
import com.revature.service.StatusService;
import com.revature.service.TypeService;
import com.revature.service.UserService;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {
	static ReimbursementService rService = new ReimbursementService();
	static UserService uService = new UserService();
	static TypeService tService = new TypeService();
	static StatusService sService = new StatusService();
	private static Logger log = Logger.getLogger(ReimbursementServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * todo
		 * convert the ids into their respective names
		 * add a button to change a reimbursement 
		 */
		List<Reimbursement> reimbursements = rService.getAll();
		// convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		log.trace("FINDING ALL REIMBURSEMENTS. JSON: " + json);

		// send response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}

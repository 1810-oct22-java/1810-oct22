package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimb;
import com.revature.service.ReimbService;

@WebServlet({"/requests","/pending","/approved","/denied"})
public class RequestServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoginServlet.class);
	static ReimbService rService = new ReimbService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			log.info("ROLE: " + session.getAttribute("roleID"));
		}
		ObjectMapper mapper = new ObjectMapper();
		int id = (int) session.getAttribute("userID");
		int role = (int) session.getAttribute("roleID");
		List<Reimb> requests = new ArrayList<Reimb>();
		switch(req.getRequestURI()) {
		case "/RequestApp/requests":
			if(role == 1) {
				requests = rService.getAllReimb();
			}else {
				requests = rService.getReimbByAuthor(id);
			}
			break;
		case "/RequestApp/pending":
			requests = rService.getReimbByStatus(1);
			log.trace(requests);
				break;
		case "/RequestApp/approved":
				requests = rService.getReimbByStatus(2);
				break;
		case "/RequestApp/denied":
				requests = rService.getReimbByStatus(3);
				break;
		}
		
		String json = mapper.writeValueAsString(requests);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application./json");
		writer.write(json);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = "partials/" + postProcess(req, resp) + ".html";
		//req.getRequestDispatcher(resourcePath).forward(req, resp);
		resp.sendRedirect("partials/reqCreationSuccess.html");
	}
	
	private String postProcess(HttpServletRequest req, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		int id = (int) session.getAttribute("userID");
		int role = (int) session.getAttribute("roleID");
		
		Reimb potential = mapper.readValue(req.getInputStream(), Reimb.class); 
		potential.setAuthor(id);
		rService.insertReimb(potential.getAmount(), potential.getDesc(), potential.getAuthor(), potential.getTypeID());
		return "reqCreationSuccess";
	}
	
	
}

package com.p1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.pojos.Reimbursement;
import com.p1.service.ReimbursementService;

@WebServlet("/reimbursement")
public class ReimbursementServlet {
	
	private static Logger logger = Logger.getLogger(ReimbursementServlet.class);
	
	static ReimbursementService rService = new ReimbursementService();

//	private void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//	}
		
}

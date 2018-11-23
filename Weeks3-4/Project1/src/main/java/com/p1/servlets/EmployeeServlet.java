package com.p1.servlets;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p1.pojos.Reimbursement;
import com.p1.service.ReimbursementService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(EmployeeServlet.class);

	static ReimbursementService rService = new ReimbursementService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> rs = rService.getAllRmbs();
		HttpSession session = req.getSession();
		String[] s = session.getAttribute("user").toString().split(", ");
		String userId = null;
		String roleId = null;
		logger.trace(s);
		for (String x : s) {
			if (x.contains("users_id")) {
				userId = x.substring(16);
				logger.trace("userId: " + userId);
			} else if (x.contains("role_id")) {
				logger.trace("x for role id: " + x);
				roleId = x.substring(8, 9);
				logger.trace("set roleId: " + roleId);
			} else {
				continue;
			}
		}
		if (roleId.equals("1") || roleId.equals("1]")) {
			for (int i = 0; i < rs.size(); i++) {
				logger.trace("roleId: " + roleId);
				logger.trace("if false, remove: " + rs.get(i).toString().contains("author=" + userId));
				logger.trace(rs.size());
				if (!rs.get(i).toString().contains("author=" + userId)) {
					logger.trace("removing");
					rs.remove(rs.get(i));
				}
				logger.trace("rs length: " + rs.size());
			}
			logger.trace("end, roleId: " + roleId);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(rs);
		logger.trace("FINDING EMP R. JSON: " + json);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
	}

}

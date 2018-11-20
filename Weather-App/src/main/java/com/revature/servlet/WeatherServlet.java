package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/weathers")
public class WeatherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		System.out.println("HERE at doGet");
//		
//		String city = req.getParameter("city");
//		System.out.println(city);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(value);
//		PrintWriter out = resp.getWriter();
//		
//		resp.setContentType("application/json");
//		out.write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}

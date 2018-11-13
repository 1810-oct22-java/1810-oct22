package com.ex.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;
import com.ex.service.DummyUserService;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
	static DummyUserService userService = new DummyUserService();
	
	
	//retrieve ALL users as JSON string
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userService.getUsers(); //get all users from "persistence"
		
		
		
	}

}

package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.pojos.Genre;
import com.ex.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet{
	static GenreService gService = new GenreService();
	private static Logger logger = Logger.getLogger(GenreServlet.class);
	
	//get all genres method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		//consult Service layer for data 
		List<Genre> genres = gService.getAll();
		
		//convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(genres);
		logger.trace("FINDING ALL GENRES. JSON: " + json);
		
		//send response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		*/
		
		PrintWriter writer = resp.getWriter();
		
		Genre test = new Genre();
		
		test.setId(2);
		test.setName("Hello");
		
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(test);
		
		writer.write(json);
		
	}
	
	//Add Genre
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Genre g = mapper.readValue(req.getInputStream(), Genre.class);
		g = gService.addGenre(g.getName());
		logger.trace("ADDED NEW GENRE " + g);
	}
	
	

}

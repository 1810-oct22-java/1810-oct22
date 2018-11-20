package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/characters")
public class CharactersServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(CharactersServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("hello");
		req.getRequestDispatcher("partials/characters.html").forward(req, resp);
	}

}

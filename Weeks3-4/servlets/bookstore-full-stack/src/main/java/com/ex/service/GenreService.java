package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.GenreDAO;
import com.ex.pojos.Genre;

public class GenreService {
	
	static DAO<Genre, Integer> gDao = new GenreDAO();
	
	
	
}

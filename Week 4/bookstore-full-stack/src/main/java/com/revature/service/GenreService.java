package com.revature.service;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.GenreDAO;
import com.revature.pojos.Genre;

public class GenreService {

	static DAO<Genre,Integer> gDao = new GenreDAO();
	
	public Genre addGenre(String name) {
		if (name==null) {
			return null;
		}
		else return gDao.save(new Genre(name));
	}
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}
	
}

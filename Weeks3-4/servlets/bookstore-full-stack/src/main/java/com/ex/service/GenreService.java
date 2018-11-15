package com.ex.service;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.GenreDAO;
import com.ex.pojos.Genre;

public class GenreService {
	//REMEMBER! Biz logic (anything that's not CRUD or internet) goes here on server side
	
	static DAO<Genre, Integer> gDao = new GenreDAO();
	
	public Genre addGenre(String name) {
		if(name == null) return null;
		else return gDao.save(new Genre(name));
	}
	
	public List<Genre> getAll(){
		return gDao.findAll();
	}
	
	
	
}

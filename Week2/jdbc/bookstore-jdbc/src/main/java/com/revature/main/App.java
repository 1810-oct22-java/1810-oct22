package com.revature.main;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.GenreDao;
import com.revature.pojos.Genre;

public class App {

	public static void main(String[] args) {

		DAO<Genre, Integer> gDao = new GenreDao();
		List<Genre> genres = gDao.findAll();
		for(Genre g : genres) {
			System.out.println(g);
		}

	}

}
package com.revature.main;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.GenreDao;
import com.revature.pojos.*;

public class App {

	public static void main(String[] args) {
		
		DAO<Genre, Integer> gDao = new GenreDao();
		List<Genre> genres = gDao.findAll();
/*
		for(Genre temp : genres) {
			System.out.println(temp);
		}
*/
		Genre g = gDao.findById(22);
		System.out.println(g);
		
		
	}
}

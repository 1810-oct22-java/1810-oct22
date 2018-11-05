package com.revature.main;
import com.revature.dao;
import com.revature.dao.GenreDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class App{

	public static void main(String[] args) {
		
		Dao<Genre, Integer> gDao = new GenreDao();
		List<Genre> genres = gDao.findAll();
		for(Genre g : genres) {
			System.out.println(g);
		}

	}

}

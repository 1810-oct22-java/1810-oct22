package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Genre;
import com.revature.util.ConnectionFactory;

public class GenreDao implements DAO<Genre, Integer>{

	/*
	 * STATEMENT - important interface in JDBC API
	 * -takes an SQL statement as a string, executes it,and
	 * returns the result
	 * -allow SQL injection. These are not ideal to use. Definitely
	 * do NOT use for any SQL command that uses a parameter/variable
	 * 
	 * SQL injection - common hacking technique. it is the insertion
	 * of code as input that affects your database
	 * */
	
	public List<Genre> findAll() {
		// TODO Auto-generated method stub
		List<Genre> genres = new ArrayList<Genre>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bn_genre order by name;";
			
			// STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represeents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);
			// returns false when there are no more rows in result set
			while(rs.next()) {
				Genre temp = new Genre();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				genres.add(temp);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}

	public Genre findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Genre save(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Genre update(Genre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Genre obj) {
		// TODO Auto-generated method stub
		
	}
     
}

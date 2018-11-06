package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Book;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class BookDao implements DAO<Book, Integer> {
	
	@Override
	public List<Book> findAll() {

		List<Book> books = new ArrayList<Book>();
		//using callable statement
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{ call GET_ALL_BOOKS(?) }"; // {} used for callable

			// STATEMENT INTERFACE - implementation exposed via connection
			CallableStatement cs = conn.prepareCall(sql);

			// ResultSet Interface - represents the result set of a DB Query
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while (rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt("book_id"));
				temp.setISBN(rs.getString(2));
				temp.setTitle(rs.getString(3));
				temp.setPrice(rs.getDouble(4));
				temp.setGenre(rs.getInt(5));
				temp.setAuthor(rs.getInt(6));
				books.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
		
	@Override
	public Book findByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book save(Book obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Book update(Book obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = " update bn_book set price = ? where book_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, obj.getPrice());
			ps.setInt(2, obj.getId());
			ps.executeUpdate(); //execute is for stored procedures and functions, this returns rows updated 
			//executequery will give results
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Book;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class BookDao implements DAO<Book, Integer> {
	
	public static void main(String[] args) {
		BookDao b = new BookDao();
		List<Book> books = b.findAll();
		for(Book t : books) {
			System.out.println(t);
		}
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{ call GET_ALL_BOOKS(?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Book temp = new Book();
				temp.setId(rs.getInt("book_id"));
				temp.setIsbn(rs.getString(2));
				temp.setAuthorId(rs.getInt(3));
				temp.setTitle(rs.getString(4));
				temp.setGenreId(rs.getInt(5));
				books.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book findById(Integer id) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Book obj) {
		// TODO Auto-generated method stub
		
	}

}

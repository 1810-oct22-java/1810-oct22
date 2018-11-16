package com.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.p1.pojos.Users;
import com.p1.util.ConnectionFactory;

public class UsersDao implements Dao<Users, Integer>{

	@Override
	public List<Users> findAll() {
		List<Users> Users = new ArrayList<Users>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Users order by users_id" ;
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);
			//returns false when there are no more rows in result set
			while(rs.next()) {
				Users temp = new Users();
				temp.setUsers_id(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirst_name(rs.getString(4));
				temp.setLast_name(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRole_id(rs.getInt(7));
				Users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	/*
	 * PREPARED STATEMENT
	 */
	@Override
	public Users findById(Integer id) {
		Users temp = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Users where users_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				temp = new Users();
				temp.setUsers_id(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirst_name(rs.getString(4));
				temp.setLast_name(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRole_id(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public Users save(Users obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Users (NAME) VALUES(?)";
			String[] keyNames = {"id"};
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
//			ps.setString(1, obj.getName());
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setUsers_id(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Users update(Users obj) {
		return null;
	}

	@Override
	public void delete(Users obj) {
		
	}
}
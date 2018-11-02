package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements DAO<User,Integer> {

	@Override
	public List<User> findAll() {
		List<User> Users = new ArrayList<User>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * from bank_User";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				User temporary = new User();
				temporary.setUserId(rs.getInt(1));
				temporary.setFirstName(rs.getString(2));
				temporary.setLastName(rs.getString(3));
				temporary.setUserName(rs.getString(4));
				temporary.setPassword(rs.getString(5));
				Users.add(temporary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
	}

	@Override
	public User findById(Integer id) {
		return null;
	}

	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Bank_User(FIRSTNAME,LASTNAME,USERNAME,PASSWORD) VALUES(?,?,?,?)";
			String[] keynames = {"Userid"};
			
			PreparedStatement ps = conn.prepareStatement(sql,keynames);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUserName());
			ps.setString(4, obj.getPassword());
			int numRows = ps.executeUpdate();
			if(numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();
			
				while(pk.next()) {
					obj.setUserId(pk.getInt(1));
				}
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public User update(User obj) {
		return null;
	}

	@Override
	public void delete(User obj) {
	}

}

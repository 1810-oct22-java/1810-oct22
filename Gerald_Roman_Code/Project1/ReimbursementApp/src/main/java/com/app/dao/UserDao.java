package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.User;
import com.app.util.ConnectionFactory;

public class UserDao implements DAO<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> user = new ArrayList<User>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USERS";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRoleId(rs.getInt(7));
				user.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User findById(Integer id) {
		User user = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User save(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub

	}

}

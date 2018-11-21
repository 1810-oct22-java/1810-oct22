package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Reimbursement;
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
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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

	//@Override
	//public User findByUserName(User obj) {
	public User findByUserName(String Username) {
		User user = null;
		
		ReimbursementDao reimbDao = new ReimbursementDao();
		List<Reimbursement> reimbursement = reimbDao.findAll();
		try {
			for (Reimbursement r : reimbursement) {
				if (r.getAuthor() == (user.getUserId()) && user.getUsername() == (usernameInput))
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		//find by user nam
		// then checks password
		//if valid user take him to the right page
	}

	@Override
	public User save(User obj) {
		User user = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(?,?,?,?,?,?)";
			String[] keyNames = { "ERS_USERS_ID" };
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleId());

			int numRows = ps.executeUpdate();
			if (numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub

	}

}

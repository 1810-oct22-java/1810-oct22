package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements DAO<User, Integer> {

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User findById(Integer id) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USER WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleID(rs.getInt(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public User save(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USER (ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID) VALUES(?,?,?,?,?,?)";
			String[] keynames = { "ERS_USERS_ID" };

			PreparedStatement ps = conn.prepareStatement(sql, keynames);
			ps.setString(1, obj.getUserName());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getRoleID());
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
		return null;
	}

	@Override
	public void delete(User obj) {
	}
	
	public User findByUsername(String username) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USER WHERE ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstName(rs.getString(4));
				u.setLastName(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleID(rs.getInt(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}
	
	public String findRole(int roleID) {
		String role = "";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE REIMB_USER_ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			role = rs.getString(2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return role;
	}

	public User checkPw(String un, String pw) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USER WHERE ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(3).equals(pw)) {
					u = new User();
					u.setUserId(rs.getInt(1));
					u.setUserName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setFirstName(rs.getString(4));
					u.setLastName(rs.getString(5));
					u.setEmail(rs.getString(6));
					u.setRoleID(rs.getInt(7));
				}else return null;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

}

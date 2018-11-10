package com.revature.Project_0_dao;
import java.util.List;

import com.revature.Project_0_CustomException.CustomException;
import com.revature.Project_0_William_Robinson.ConnectionFactory;
import com.revature.Project_0_William_Robinson.Log;
import com.revature.Project_0_pojos.Account;
import com.revature.Project_0_pojos.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends Log  implements DAO<User, Integer>{

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO USERA (USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES(?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.executeUpdate();
				conn.commit();
	
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

	
	public User findByUsername(String username) {
		User u = new User();
		//u.setUsername(username);
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select username, password, firstname, lastname from usera where username = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setFirstname(rs.getString(3));
				u.setLastname(rs.getString(4));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public User findByPassword(String password) {
		User u = new User();
		//u.setPassword(password);
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select password from usera where password = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, u.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setPassword(rs.getString(1));


			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User findByUsername(Integer String) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

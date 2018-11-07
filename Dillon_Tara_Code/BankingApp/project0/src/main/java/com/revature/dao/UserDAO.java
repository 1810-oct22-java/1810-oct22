package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class UserDAO implements DAO<User, Integer> {
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{ call getallusers(?) }"; 

			// Callable Statement
			/*
			 * create or replace procedure 
			 * getallusers(user_cursor OUT sys_refcursor)
			 * as
			 * begin
			 * 		open user_cursor for select * from THEUSER;
			 * end;
			 * 
			 * */
			
			CallableStatement cs = conn.prepareCall(sql);

			// ResultSet Interface - represents the result set of a DB Query
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while (rs.next()) {
				User temp = new User();
				temp.setUserid(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassWord(rs.getString(4));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	
	@Override
	public User findById(Integer id) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//select * from theuser order by userid;
			String sql = "select * from theuser where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserid(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassWord(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public User findByUsername(String username, String password) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Select * From THEUSER Where Username = ? AND Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserid(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassWord(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "Insert into THEUSER (UserId, FirstName, LastName, UserName, PassWord) Values(?,?,?,?,?)"; 
			String[] keyNames = {"UserId", "FirstName", "LastName", "UserName", "PassWord"};

			PreparedStatement ps = conn.prepareStatement(sql, keyNames);

			ps.setInt(1, obj.getUserid());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getUserName());
			ps.setString(5, obj.getPassWord());

			int numRows = ps.executeUpdate();

			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setUserid(pk.getInt(1));
					obj.setFirstName(pk.getString(2));
					obj.setLastName(pk.getString(3));
					obj.setUserName(pk.getString(4));
					obj.setPassWord(pk.getString(5));
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Update THEUSER set FirstName = ?, LastName = ? UserName = ? PassWord = ? Where UserId = ?";  
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getUserName());
			ps.setString(4, obj.getPassWord());
			ps.setInt(5, obj.getUserid());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

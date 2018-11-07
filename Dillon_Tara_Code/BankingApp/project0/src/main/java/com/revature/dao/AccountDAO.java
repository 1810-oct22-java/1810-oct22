package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO implements DAO<Account, Integer> {
	
	@Override
	public List<Account> findAll() {
		List<Account> account = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * From THEACCOUNT Order By ACCOUNTID";
			
				Statement statement = conn.createStatement();
			
				ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setUserId(rs.getInt(1));
				temp.setTypeId(rs.getInt(2));
				temp.setUserId(rs.getInt(3));
				temp.setBalance(rs.getInt(4));
				account.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public Account findById(Integer id) {
		Account a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from UserAccount where AccountId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Account();
				a.setAccountId(rs.getInt(1));
				a.setTypeId(rs.getInt(2));
				a.setUserId(rs.getInt(3));
				a.setBalance(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public Account save(Account obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql ="Insert Into THEACCOUNT (AccountID, UserID, TypeID, AcctBalance) Values(?, ?, ?, ?)"; 
			String[] keyNames = {"AccountId", "UserID", "TypeID", "AcctBalance"};
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			
			ps.setInt(1, obj.getAccountId());
			ps.setInt(2, obj.getTypeId());
			ps.setInt(3, obj.getUserId());
			ps.setInt(4, obj.getBalance());
			

			int numRows = ps.executeUpdate();//error
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setTypeId(pk.getInt(1));
					obj.setUserId(pk.getInt(2));
					obj.setBalance(pk.getInt(3));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public Account update(Account obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql ="Update THEACCOUNT Set AcctBalance = ? Where AccountID = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, obj.getBalance());
			ps.setInt(2, obj.getAccountId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

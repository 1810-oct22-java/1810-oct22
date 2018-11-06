package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.db.objects.Account;
import com.revature.util.ConnectionFactory;

public class AccountDao {
	
	public static void main(String[] args) {
		
	}

	public static void addAccount(Account account) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "INSERT INTO account(userId,accountType,accountBalance) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeQuery();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.db.objects.Account;
import com.revature.db.objects.Customer;
import com.revature.exception.accountdao.WithdrawAmountExceedsBalanceException;
import com.revature.exception.customerdao.InvalidAccountCredentialsException;
import com.revature.util.ConnectionFactory;

public class AccountDao {
	
	public static void main(String[] args) {
		Customer cust = new Customer();
		cust.setUsername("test");
		cust.setPassword("test");
		
		try {
			cust = CustomerDao.loginAttempt(cust);
		} catch (InvalidAccountCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(cust.getUserId());
		
		
		Account acc = new Account();
		acc.setAccountBalance(300.00);
		acc.setAccountType("checking");
		acc.setUserId(cust.getUserId());
		acc.setAccountId(5);
		
		try {
			withdraw(acc, 200);
		} catch (WithdrawAmountExceedsBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addAccount(Customer user, Account account) throws SQLException {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "INSERT INTO account(userId,accountType,balance) VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, account.getAccountType());
			ps.setDouble(3, account.getAccountBalance());
			ps.executeQuery();
		}
	}
	
	public static ResultSet getAssociatedAccounts(Customer user) throws SQLException {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			
			
			ResultSet rs =  (ResultSet) ps.executeQuery();
			
			while(rs.next()) System.out.println(rs.getInt(1) + " " + rs.getDouble(3));
			
			return rs;
			
		}
	}
	
	public static void withdraw(Account acc, double amount) throws WithdrawAmountExceedsBalanceException, SQLException {
		
		double newBalance = acc.getAccountBalance() - amount;
		
		if(newBalance < 0) throw new WithdrawAmountExceedsBalanceException();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ? AND BALANCE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, acc.getAccountId());
			ps.setDouble(3, acc.getAccountBalance());
			
			int rowsEffected = ps.executeUpdate();
			
			//if(rowsEffected == 0) throw new 
			
			System.out.println(rowsEffected);
		}
	}
}

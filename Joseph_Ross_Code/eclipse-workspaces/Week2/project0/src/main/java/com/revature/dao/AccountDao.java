package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.db.objects.Account;
import com.revature.db.objects.Customer;
import com.revature.exception.accountdao.AccountInformationUpdatedAfterLastRetriveException;
import com.revature.exception.accountdao.InvalidTransactionTypeException;
import com.revature.exception.accountdao.WithdrawAmountExceedsBalanceException;
import com.revature.util.ConnectionFactory;

public class AccountDao {
	
	/*
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
		acc.setAccountBalance(300);
		acc.setAccountType("checking");
		acc.setUserId(cust.getUserId());
		acc.setAccountId(5);
		
		Account acc2 = new Account();
		acc2.setAccountBalance(650);
		acc2.setAccountType("savings");
		acc2.setUserId(cust.getUserId());
		acc2.setAccountId(4);
		
		try {
			transfer(acc, acc2, 50);
		} catch (WithdrawAmountExceedsBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountInformationUpdatedAfterLastRetriveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTransactionTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

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
	
	public static ArrayList<Account> getAssociatedAccounts(Customer user) throws SQLException {
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			
			
			ResultSet rs =  (ResultSet) ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(1)));
			}
		}
		
		return accounts;
	}
	
	public static void changeBalance(Account acc, double amount, String transactionType) throws WithdrawAmountExceedsBalanceException, SQLException, AccountInformationUpdatedAfterLastRetriveException, InvalidTransactionTypeException {
		
		double newBalance = 0;
		
		if(transactionType == "withdraw") newBalance = acc.getAccountBalance() - amount;
		if(transactionType == "deposit") newBalance = acc.getAccountBalance() + amount;
		else throw new InvalidTransactionTypeException();
		
		if(newBalance < 0) throw new WithdrawAmountExceedsBalanceException();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ? AND BALANCE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, acc.getAccountId());
			ps.setDouble(3, acc.getAccountBalance());
			
			int rowsEffected = ps.executeUpdate();
			
			if(rowsEffected == 0) throw new AccountInformationUpdatedAfterLastRetriveException();
		}
	}

	public static void transfer(Account fromAccount, Account toAccount, double amount) throws WithdrawAmountExceedsBalanceException, SQLException, AccountInformationUpdatedAfterLastRetriveException, InvalidTransactionTypeException {
		
		double fromAccountNewBalance = fromAccount.getAccountBalance() - amount;
		double toAccountNewBalance = toAccount.getAccountBalance() + amount;
		
		if(fromAccountNewBalance < 0) throw new WithdrawAmountExceedsBalanceException();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ? AND BALANCE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, fromAccountNewBalance);
			ps.setInt(2, fromAccount.getAccountId());
			ps.setDouble(3, fromAccount.getAccountBalance());
			
			int rowsEffected = ps.executeUpdate();
			if(rowsEffected == 0) throw new AccountInformationUpdatedAfterLastRetriveException();
			
			sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ? AND BALANCE = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setDouble(1, toAccountNewBalance);
			ps2.setInt(2, toAccount.getAccountId());
			ps2.setDouble(3, toAccount.getAccountBalance());
			
			rowsEffected = ps2.executeUpdate();
			if(rowsEffected == 0) throw new AccountInformationUpdatedAfterLastRetriveException();
			
			conn.commit();
		}
	}
}

package com.revature.Project_0_dao;

import java.util.List;

import com.revature.Project_0_CustomException.CustomException;
import com.revature.Project_0_William_Robinson.ConnectionFactory;
import com.revature.Project_0_William_Robinson.Log;
import com.revature.Project_0_pojos.Account;

import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends Log  implements DAO<Account, Integer> {
     
	public List<Account> findAll2() {
		/*
		 * 		List<Book> books = new ArrayList<Book>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
		 * */
		
		
		List<Account> Account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
		//	String query = "select id, username, balance, type from account" ;
			String sql = "{ call GET_ALL_USERS(?) }";
			CallableStatement cs = conn.prepareCall(sql);
			//STATEMENT INTERFACE - implementation exposed via connection
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);

			while(rs.next()) {
				Account temp = new Account();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setBalance(rs.getInt(3));
				temp.setType(rs.getString(4));
				Account.add(temp);
				
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return Account;
	}
	
	
	
	public List<Account> findAll1() {
		List<Account> Account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select id, username, balance, type from account" ;
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
			while(rs.next()) {
				Account temp = new Account();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setBalance(rs.getInt(3));
				temp.setType(rs.getString(4));
				Account.add(temp);
				
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return Account;
	}

	
	
	
@Override
	public List<Account> findAll() {
		List<Account> Account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select username, balance, type from account where username = ?" ;
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
			while(rs.next()) {
				Account temp = new Account();
				temp.setUsername(rs.getString(1));
				temp.setBalance(rs.getInt(2));
				temp.setType(rs.getString(3));
				Account.add(temp);
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return Account;
	}

	@Override
	public Account findById(Integer id) {
		Account a = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from account where username ="+Log.$$username +"type = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Account();
				a.setUsername(rs.getString(1));
				a.setBalance(rs.getInt(2));
				a.setType(rs.getString(3));
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
			
			String sql = "INSERT INTO ACCOUNT (USERNAME, BALANCE, TYPE) VALUES(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setString(1, obj.getUsername());
			ps.setInt(2, obj.getBalance());
			ps.setString(3, obj.getType());
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	public Account update(Account obj, int balance) {
		//obj = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE USERNAME= ? AND TYPE = ? AND ID = ?";
			obj.setBalance(balance);
			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setInt(1, new Integer(obj.getBalance()));
			ps.setString(2, obj.getUsername());
			ps.setString(3, obj.getType());
			ps.setInt(4, obj.getId());
			
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}
	//}
	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Account> findByUsername(String username) {
			List<Account> account = new ArrayList<Account>();
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
				String query = "select distinct id, username, balance, type from account where username = ?" ;
				PreparedStatement ps = conn.prepareStatement(query); 
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				//STATEMENT INTERFACE - implementation exposed via connection
				//Statement statement = conn.createStatement();
				//statement.setString(1, username);
				//ResultSet Interface - represents the result set of a DB query
				//ResultSet rs = statement.executeQuery(query);
				
				//returns false when there are no more rows in result set
				while(rs.next()) {
					Account temp = new Account();
					temp.setId(rs.getInt(1));
					temp.setUsername(rs.getString(2));
					temp.setBalance(rs.getInt(3));
					temp.setType(rs.getString(4));
					account.add(temp);
				}
				
			} catch (SQLException e) {
				try {
					throw new CustomException();
				} catch (CustomException e1) {
				
					e1.printStackTrace();
				}
			}
			return account;
		}
	

	@Override
	public Account findByUsername(Integer String) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Account> findByUsernameandType(String username, String type) {
		List<Account> account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select distinct id, username, balance, type from account where username = ? and type = ?" ;
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, username);
			ps.setString(2, type);
			ResultSet rs = ps.executeQuery();
			//STATEMENT INTERFACE - implementation exposed via connection
			//Statement statement = conn.createStatement();
			//statement.setString(1, username);
			//ResultSet Interface - represents the result set of a DB query
			//ResultSet rs = statement.executeQuery(query);
			
			//returns false when there are no more rows in result set
			while(rs.next()) {
				Account temp = new Account();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setBalance(rs.getInt(3));
				temp.setType(rs.getString(4));
				account.add(temp);
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return account;
	}

	public int findById(String username, int id) {
		List<Account> account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select distinct id, username, balance, type from account where username = ? and id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, username);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			Account temp = new Account();
			
			//STATEMENT INTERFACE - implementation exposed via connection
			//Statement statement = conn.createStatement();
			//statement.setString(1, username);
			//ResultSet Interface - represents the result set of a DB query
			//ResultSet rs = statement.executeQuery(query);
			
			//returns false when there are no more rows in result set
			while(rs.next()) {
			//	Account temp = new Account();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setBalance(rs.getInt(3));
				temp.setType(rs.getString(4));
				account.add(temp);
				id = temp.getId();
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int findByBalance(String username, int id, int balance) {
		//List<Account> account = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select distinct id, username, balance, type from account where username = ? and id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, username);
			ps.setInt(2, id);
			Account temp = new Account();
			ResultSet rs = ps.executeQuery();
			
			
			//STATEMENT INTERFACE - implementation exposed via connection
			//Statement statement = conn.createStatement();
			//statement.setString(1, username);
			//ResultSet Interface - represents the result set of a DB query
			//ResultSet rs = statement.executeQuery(query);
			
			//returns false when there are no more rows in result set
			while(rs.next()) {
			//	Account temp = new Account();
				balance = temp.getBalance();
				temp.setId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setBalance(rs.getInt(3));
				temp.setType(rs.getString(4));
			//	account.add(temp);
				
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return balance;
	}
	
	
	public int findByBalance(String username, int id) {
		AccountDao acc= new AccountDao();
		Account a = new Account();
		id = acc.findById(username, id);
		String type = a.getType();
		
		int balance= a.getBalance();
		
		List<Account> account = new ArrayList<Account>();
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select distinct id, username, balance, type from account where username = ? and id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, username);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			//Account temp = new Account();
			
			//STATEMENT INTERFACE - implementation exposed via connection
			//Statement statement = conn.createStatement();
			//statement.setString(1, username);
			//ResultSet Interface - represents the result set of a DB query
			//ResultSet rs = statement.executeQuery(query);
			balance = a.getBalance();
			//returns false when there are no more rows in result set
			while(rs.next()) {
			//	Account temp = new Account();
				a.setId(rs.getInt(1));
				a.setUsername(rs.getString(2));
				a.setBalance(rs.getInt(3));
				a.setType(rs.getString(4));
			//	temp.setType(rs.getString(4));
				//balance = temp.getBalance();
				//account.add(temp);
			//	id = temp.getId();
				balance = a.getBalance();
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return balance;
	}
	
	

}

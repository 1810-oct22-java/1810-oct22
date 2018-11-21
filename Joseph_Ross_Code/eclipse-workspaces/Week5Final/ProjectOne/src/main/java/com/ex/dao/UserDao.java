package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.ReimbursementEntry;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

import com.ex.exception.InvalidUsernameAndPasswordException;

public class UserDao {
	
	public static void main(String[] args) {
		
		/*
		
		User temp = new User();
		temp.setUserId(1);
		
		try {
			ArrayList<ReimbursementEntry> test = getAllSubmittedReimburements(temp);
			
			for(int i = 0; i < test.size(); i++) {
				System.out.println(test.get(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		
			
			ReimbursementEntry re = new ReimbursementEntry();
			
			re.setAmount(80.50);
			re.setDesc("Dao test");
			re.setReimbTypeId(2);
			
			User user = new User();
			user.setUserId(3);
			
			try {
				SubmitReimburement(user,re);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/
		
		try {
			loginAttempt("manager", "12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static User loginAttempt(String username, String password) throws SQLException, InvalidUsernameAndPasswordException {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "SELECT ERS_USERS_ID, ERS_USERNAME, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			if(!rs.next()) {
				throw new InvalidUsernameAndPasswordException();
			}
			
			//Create the user object
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setFirstName(rs.getString(3));
			user.setLastName(rs.getString(4));
			user.setEmail(rs.getString(5));
			user.setRole(rs.getInt(6));
			
			return user;
		}
	}
	
	public static ArrayList<ReimbursementEntry> getAllSubmittedReimburements(User user) throws SQLException{
		
		ArrayList<ReimbursementEntry> reimbRecords = new ArrayList<ReimbursementEntry>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = " + user.getUserId();
			
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				ReimbursementEntry temp = new ReimbursementEntry();
				temp.setReimbId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setTimeSubmitted(rs.getString(3));
				temp.setTimeResolved(rs.getString(4));
				temp.setDesc(rs.getString(5));
				temp.setUserId(rs.getInt(7));
				temp.setResolverId(rs.getInt(8));
				temp.setStatusId(rs.getInt(9));
				temp.setReimbTypeId(rs.getInt(10));
				reimbRecords.add(temp);
			}
		}
		return reimbRecords;
	}
	
	public static void SubmitReimburement(User user, ReimbursementEntry record) throws SQLException {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String query = "{ call INSERT_ERS_REIMBURSEMENT(?,?,?,?) }";
			CallableStatement cs = conn.prepareCall(query);
			cs.setDouble(1, record.getAmount());
			cs.setString(2, record.getDesc());
			cs.setInt(3, user.getUserId());
			cs.setInt(4, record.getReimbTypeId());
			
			cs.execute();
			
			
		}
		
	}

}


/*
 * Login page:
 * 	* ValidateCredentials
 * 		- Gets username and password and cookie
 * 		- If username and password are correct start the session
 * 		- If username and password are not correct tell the client
 * 
 * Employee page:
 * 	* Get all reimbursement records for that user
 *  * Submit new reimbursement request
 *  	- If there is an error tell the client
 *  	- If not add the record and tell the client
 *
 * Manager page:
 * 	* View all requests
 * 	* Submit decision for a specific request
 *
 * 
 * 
 * 
 * 
 * 
 * */

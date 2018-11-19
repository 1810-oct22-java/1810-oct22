package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Reimbursement;
import com.app.util.ConnectionFactory;

public class ReimbursementDao implements DAO<Reimbursement, Integer>{

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> rmb = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ERS_REIMBURSEMENT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setSubmitted(rs.getDate(3));
				temp.setResolved(rs.getDate(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
			}
				
			}catch(SQLException e) {
				e.printStackTrace();
		}return rmb;
	}

	@Override
	public Reimbursement findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIM_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";		
					
			String[] keyNames = {"ID"};//need to change;
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			
			ps.setInt(1,obj.getAmount());
			ps.setDate(2,obj.getSubmitted());
			ps.setDate(3,obj.getResolved());
			ps.setString(4, obj.getDescription());
			ps.setInt(5,obj.getAuthor());
			ps.setInt(6, obj.getResolver());
			ps.setInt(7, obj.getStatusId());
			ps.setInt(8, obj.getTypeId());
			
			int numRows = ps.executeUpdate();
			if(numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {					
					obj.setId(pk.getInt(1));
					
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}	

}

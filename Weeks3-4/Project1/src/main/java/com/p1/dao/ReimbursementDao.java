package com.p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.p1.pojos.Reimbursement;
import com.p1.util.ConnectionFactory;

public class ReimbursementDao implements Dao<Reimbursement, Integer>{

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from reimbursement order by id" ;
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);
			//returns false when there are no more rows in result set
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3));
				temp.setResolved(rs.getDate(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatus_id(rs.getInt(8));
				temp.setType_id(rs.getInt(9));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}

	/*
	 * PREPARED STATEMENT
	 */
	@Override
	public Reimbursement findById(Integer id) {
		Reimbursement g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from reimbursement where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				g = new Reimbursement();
				g.setId(rs.getInt(1));
				g.setAmount(rs.getDouble(2));
				g.setSubmitted(rs.getDate(3));
				g.setResolved(rs.getDate(4));
				g.setDescription(rs.getString(5));
				g.setAuthor(rs.getInt(6));
				g.setResolver(rs.getInt(7));
				g.setStatus_id(rs.getInt(8));
				g.setType_id(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Reimbursement (NAME) VALUES(?)";
			String[] keyNames = {"id"};
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
//			ps.setString(1, obj.getName());
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
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
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		
	}
}
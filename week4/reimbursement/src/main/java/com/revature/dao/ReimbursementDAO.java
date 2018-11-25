package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement, Integer> {

	@Override
	public List findAll() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			System.out.println("inside try");
			String query = "select * from ERS_REIMBURSEMENT order by REIMB_ID";

			// STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();

			// ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			// returns false when there are no more rows in result set
			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbID(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getDate(3));
				temp.setReimbResolved(rs.getDate(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusID(rs.getInt(9));
				temp.setReimbTypeID(rs.getInt(10));
				reimbursements.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement findById(Integer id) {
		Reimbursement r = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from ERS_REIMBURSEMENT where REIMB_ID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement();
				r.setReimbID(rs.getInt(1));
				System.out.println(r.getReimbID());
				r.setReimbAmount(rs.getDouble(2));
				r.setReimbSubmitted(rs.getDate(3));
				r.setReimbResolved(rs.getDate(4));
				r.setReimbDescription(rs.getString(5));
				r.setReimbAuthor(rs.getInt(7));
				r.setReimbResolver(rs.getInt(8));
				r.setReimbStatusID(rs.getInt(8));
				r.setReimbTypeID(rs.getInt(10));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("exception");
		}
		return r;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "INSERT INTO ERS_REIMBURSEMENT"
					+ " (REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_RESOLVED,REIMB_DESCRIPTION,"
					+ "REIMB_RECEIPT,REIMB_AUTHOR,REIMB_RESOLVER,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES(?,?,?,?,?,?,?,?,?)";
			String[] keyNames = { "Reimb_Id" };

			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setDouble(1, obj.getReimbAmount());
			ps.setDate(2, obj.getReimbSubmitted());
			ps.setDate(3, obj.getReimbResolved());
			ps.setString(4, obj.getReimbDescription());
			ps.setString(5, obj.getReimbReceipt());
			ps.setInt(6, obj.getReimbAuthor());
			ps.setInt(7, obj.getReimbResolver());
			ps.setInt(8, obj.getReimbStatusID());
			ps.setInt(9, obj.getReimbTypeID());

			int numRows = ps.executeUpdate();
			if (numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					obj.setReimbID(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Reimbursement update(int id, int status) {
		System.out.println("update dao method");
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update ERS_REIMBURSEMENT set REIMB_STATUS_ID = ? where REIMB_ID= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("finished update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> findAll(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			System.out.println("inside try");
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_AUTHOR=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			// returns false when there are no more rows in result set
			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbID(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getDate(3));
				temp.setReimbResolved(rs.getDate(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbAuthor(rs.getInt(7));
				temp.setReimbResolver(rs.getInt(8));
				temp.setReimbStatusID(rs.getInt(9));
				temp.setReimbTypeID(rs.getInt(10));
				reimbursements.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

}

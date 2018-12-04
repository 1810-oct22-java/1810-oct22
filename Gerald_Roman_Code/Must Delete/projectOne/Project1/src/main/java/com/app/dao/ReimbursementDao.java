package com.app.dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Reimbursement;
import com.app.util.ConnectionFactory;

public class ReimbursementDao implements DAO<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> rmb = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDate(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));
				rmb.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rmb;
	}

	@Override
	public Reimbursement findById(Integer id) {
		Reimbursement reimb = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setId(rs.getInt(1));
				reimb.setAmount(rs.getDouble(2));
				reimb.setSubmitted(rs.getDate(3));
				reimb.setResolved(rs.getTimestamp(4));
				reimb.setDescription(rs.getString(5));
				reimb.setAuthor(rs.getInt(6));
				reimb.setResolver(rs.getInt(7));
				reimb.setStatusId(rs.getInt(8));
				reimb.setTypeId(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIM_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";

			String[] keyNames = { "ID" };// need to change;
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);

			ps.setDouble(1, obj.getAmount());
			ps.setDate(2, obj.getSubmitted());
			ps.setTimestamp(3, obj.getResolved());
			ps.setString(4, obj.getDescription());
			ps.setInt(5, obj.getAuthor());
			ps.setInt(6, obj.getResolver());
			ps.setInt(7, obj.getStatusId());
			ps.setInt(8, obj.getTypeId());

			int numRows = ps.executeUpdate();
			if (numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
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
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = ?,REIMB_RESOLVER = ?,REIMB_STATUS_ID = ? FROM ERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, obj.getResolved());
			ps.setInt(2,obj.getResolver());
			ps.setInt(3, obj.getStatusId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimb;
import com.revature.util.ConnectionFactory;

public class ReimbDAO implements DAO<Reimb,Integer> {

	@Override
	public List<Reimb> findAll() {
		List<Reimb> reimbs = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb r = new Reimb();
				r.setrID(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getTimestamp(3));
				r.setResolved(rs.getTimestamp(4));
				r.setDesc(rs.getString(5));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusID(rs.getInt(9));
				r.setTypeID(rs.getInt(10));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbs;
	}

	@Override
	public Reimb findById(Integer id) {
		Reimb r = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r = new Reimb();
				r.setrID(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getTimestamp(3));
				r.setResolved(rs.getTimestamp(4));
				r.setDesc(rs.getString(5));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusID(rs.getInt(9));
				r.setTypeID(rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public Reimb save(Reimb obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES(?,?,?,?,?,?)";
			String[] keynames = { "REIMB_ID" };
			
			PreparedStatement ps = conn.prepareStatement(sql, keynames);
			ps.setInt(1, obj.getAmount());
			ps.setTimestamp(2, obj.getSubmitted());
			ps.setString(3, obj.getDesc());
			ps.setInt(4, obj.getAuthor());
			ps.setInt(5, obj.getStatusID());
			ps.setInt(6, obj.getTypeID());
			int numRows = ps.executeUpdate();
			if (numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();

				while (pk.next()) {
					obj.setrID((pk.getInt(1)));
				}
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public Reimb update(Reimb obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update ERS_REIMBURSEMENT SET REIMB_RESOLVED = ?,REIMB_RESOLVER = ?,REIMB_STATUS_ID = ? WHERE REIMB_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, obj.getResolved());
			ps.setInt(2, obj.getResolver());
			ps.setInt(3, obj.getStatusID());
			ps.setInt(4, obj.getrID());
			ps.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Reimb obj) {
	}

	public List<Reimb> findAllByAuthor(Integer id) {
		List<Reimb> reimbs = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb r = new Reimb();
				r.setrID(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getTimestamp(3));
				r.setResolved(rs.getTimestamp(4));
				r.setDesc(rs.getString(5));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusID(rs.getInt(9));
				r.setTypeID(rs.getInt(10));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbs;
	}
	
	public List<Reimb> findAllByStatus(Integer id) {
		List<Reimb> reimbs = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimb r = new Reimb();
				r.setrID(rs.getInt(1));
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getTimestamp(3));
				r.setResolved(rs.getTimestamp(4));
				r.setDesc(rs.getString(5));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusID(rs.getInt(9));
				r.setTypeID(rs.getInt(10));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbs;
	}
	
	public String findStatus(int id) {
		String status = "";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = rs.getString(2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public String findType(int typeID) {
		String type = "";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			type = rs.getString(2);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return type;
	}
}

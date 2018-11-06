package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO implements DAO<Account,Integer>{

	@Override
	public List<Account> findAll() {
		List<Account> Accounts = new ArrayList<Account>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * from bank_Account";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Account temporary = new Account();
				temporary.setAccountId(rs.getInt(1));
				temporary.setTypeId(rs.getInt(2));
				temporary.setOwner(rs.getInt(3));
				temporary.setBalance(rs.getInt(4));
				Accounts.add(temporary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Accounts;
	}

	@Override
	public Account findById(Integer id) {
		Account u = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Account WHERE accountid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setAccountId(rs.getInt(1));
				u.setTypeId(rs.getInt(2));
				u.setOwner(rs.getInt(3));
				u.setBalance(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public Account save(Account obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Bank_Account(TYPEID,OWNER,BALANCE) VALUES(?,?,?)";
			String[] keynames = { "Accountid" };

			PreparedStatement ps = conn.prepareStatement(sql, keynames);
			ps.setInt(1, obj.getTypeId());
			ps.setInt(2, obj.getOwner());
			ps.setInt(3, obj.getBalance());
			int numRows = ps.executeUpdate();
			if (numRows == 1) {
				ResultSet pk = ps.getGeneratedKeys();

				while (pk.next()) {
					obj.setAccountId(pk.getInt(1));
				}
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public Account update(Account obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Update Bank_Account SET BALANCE = ? WHERE Owner = ? AND typeid = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getBalance());
			ps.setInt(2, obj.getOwner());
			ps.setInt(3, obj.getTypeId());
			ps.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}
	

	@Override
	public void delete(Account obj) {	
	}

	public List<Account> findAllById(Integer id) {
		List<Account> Accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Account WHERE owner = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account u = new Account();
				u.setAccountId(rs.getInt(1));
				u.setTypeId(rs.getInt(2));
				u.setOwner(rs.getInt(3));
				u.setBalance(rs.getInt(4));
				Accounts.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Accounts;
	}
}

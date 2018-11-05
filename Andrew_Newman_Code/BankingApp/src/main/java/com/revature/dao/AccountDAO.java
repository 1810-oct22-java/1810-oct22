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
		return null;
	}

	@Override
	public Account save(Account obj) {
		return null;
	}

	@Override
	public Account update(Account obj) {
		return null;
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

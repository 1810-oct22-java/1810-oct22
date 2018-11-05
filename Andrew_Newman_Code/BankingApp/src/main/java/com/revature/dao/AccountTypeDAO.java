package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.AccountType;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class AccountTypeDAO implements DAO<AccountType,Integer> {

	@Override
	public List<AccountType> findAll() {
		List<AccountType> Accounts = new ArrayList<AccountType>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * from bank_Account_type";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				AccountType temporary = new AccountType();
				temporary.setTypeId(rs.getInt(1));
				temporary.setType(rs.getString(2));
				Accounts.add(temporary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Accounts;
	}

	@Override
	public AccountType findById(Integer id) {
		AccountType u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM Bank_Account_Type WHERE typeid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new AccountType();
				u.setTypeId(rs.getInt(1));
				u.setType(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public AccountType save(AccountType obj) {
		return null;
	}

	@Override
	public AccountType update(AccountType obj) {
		return null;
	}

	@Override
	public void delete(AccountType obj) {
		
	}

}

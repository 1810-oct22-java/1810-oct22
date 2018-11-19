/**
 * 
 */
package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.beans.AccountBean;
import com.banking.io.ConnectionFactory;

/**
 * @author Phil
 *
 */
public class AccountDAO implements DAO<AccountBean, Integer> {

	@Override
	public List<AccountBean> getAll(Integer userID) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		
		try {
			String sql = "select a.account_id, a.user_id, a.type_id, t.name, a.balance " +
						"from acme_account a " + 
					    "join acme_type t on a.type_id = t.type_id and " +
						"a.user_id = ? ";
			Connection conn = ConnectionFactory.getInstance().getConnection();
					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID.intValue());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountBean bean = new AccountBean();
				bean.setID(rs.getInt(1));
				bean.setUser_id(rs.getInt(2));
				bean.setType_id(rs.getInt(3));
				bean.setType(rs.getString(4));
				bean.setBalance(rs.getDouble(5));
				
				list.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<AccountBean> getAll() {
		// we have no need to return all of the product rows
		return null;
	}

	@Override
	public AccountBean getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean insert(AccountBean obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// key names indicates an autogenerated field so the value can be returned
			String sql = "insert into acme_account (user_id, type_id, balance)\r\n" + 
						"values (?,?,?)";
			String[] keyNames = {"account_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setInt(1, obj.getUser_id());
			ps.setInt(2, obj.getType_id());
			ps.setDouble(3, obj.getBalance());

			int numrows = ps.executeUpdate();
			if (numrows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					obj.setID(rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public AccountBean update(AccountBean obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// key names indicates an autogenerated field so the value can be returned
			String sql = "update acme_account set balance = ? where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getID());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(AccountBean obj) {
		// TODO Auto-generated method stub
		
	}

}
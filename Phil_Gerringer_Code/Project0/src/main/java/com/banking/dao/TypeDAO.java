/**
 * 
 */
package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking.beans.TypeBean;
import com.banking.io.ConnectionFactory;

/**
 * @author Phil
 *
 */
public class TypeDAO implements DAO<TypeBean, Integer> {

	@Override
	public List<TypeBean> getAll() {
		List<TypeBean> list = new ArrayList<TypeBean>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from acme_type";
			
			Statement stmt = conn.createStatement();
			
			
			//PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TypeBean bean = new TypeBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				
				list.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public TypeBean getByID(Integer id) {
		TypeBean bean=null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {		
			String sql = "select * from acme_type where type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new TypeBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bean;
	}

	@Override
	public TypeBean insert(TypeBean obj) {
		// static table, no insert
		return null;
	}

	@Override
	public TypeBean update(TypeBean obj) {
		// static table, no update
		return null;
	}

	@Override
	public void delete(TypeBean obj) {
		// static table, no delete
		
	}

	@Override
	public List<TypeBean> getAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

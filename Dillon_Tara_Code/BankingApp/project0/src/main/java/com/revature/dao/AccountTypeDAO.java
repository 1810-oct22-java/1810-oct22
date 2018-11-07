package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.AcctType;
import com.revature.util.ConnectionFactory;

public class AccountTypeDAO implements DAO<AcctType, Integer> {

	@Override
	public List<AcctType> findAll() {
		List<AcctType> type = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * From ACCTTYPE Order By TypeID";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
				while(rs.next()) {
					AcctType temp = new AcctType();
					temp.setTypeId(rs.getInt(1));
					temp.setTypeName(rs.getString(2));
					type.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
	
	@Override
	public AcctType findById(Integer id) {
		AcctType at = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Select * From ACCTTYPE Where TypedId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					at = new AcctType();
					at.setTypeId(rs.getInt(1));
					at.setTypeName(rs.getString(2));
			}
		} 
			catch (SQLException e) 
		{
		e.printStackTrace();
		}
	return at;
  }
	
	@Override
	public AcctType save(AcctType obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			
			String sql = "Insert Into ACCTTYPE(TypeID, TypeName) Values(?, ?)"; 
			String[] keyNames = {"TypeId", "TypeName"};

			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			
			ps.setInt(1, obj.getTypeId());
			ps.setString(2, obj.getTypeName());

			int numRows = ps.executeUpdate();

			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setTypeId(pk.getInt(1));
					obj.setTypeName(pk.getString(2));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public AcctType update(AcctType obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql ="Update ACCTTYPE Set TypeName = ? Where TypeId = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setString(1, obj.getTypeName());
			ps.setInt(2, obj.getTypeId());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void delete(AcctType obj) {
		// TODO Auto-generated method stub	
	}
	
	
}

package EXAMPLE.dao;
import java.util.List;
import EXAMPLE.CustomException.CustomException;


import EXAMPLE.Project_1_William_Robinson.ConnectionFactory;
import EXAMPLE.pojos.ers_user;
import EXAMPLE.pojos.ers_reimbursement;
import oracle.jdbc.internal.OracleTypes;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class ReimbursementDao implements DAO<ers_reimbursement, Integer>{

	public List<ers_reimbursement> findAll2() {
		List<ers_reimbursement> ers_reimbursement = new ArrayList<ers_reimbursement>();
				
				try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
					String query = "select * from ers_reimbursement where reimb_status_id = 2 order by reimb_id" ;
					
					//STATEMENT INTERFACE - implementation exposed via connection
					Statement statement = conn.createStatement();
					
					//ResultSet Interface - represents the result set of a DB query
					ResultSet rs = statement.executeQuery(query);

					//returns false when there are no more rows in result set
					while(rs.next()) {
						ers_reimbursement temp = new ers_reimbursement();
						temp.setReimb_id(rs.getInt(1));
						temp.setReimb_amount(rs.getInt(2));
						temp.setReimb_submitted(rs.getString(3));
						temp.setReimb_resolved(rs.getString(4));
						temp.setReimb_description(rs.getString(5));
						temp.setReimb_receipt(rs.getObject(6));
						temp.setReimb_author(rs.getInt(7));
						temp.setReimb_resolver(rs.getInt(8));
						temp.setReimb_status_id(rs.getInt(9));
						temp.setReimb_type_id(rs.getInt(10));
				
						ers_reimbursement.add(temp);
						
					}
					
				} catch (SQLException e) {
					try {
						throw new CustomException();
					} catch (CustomException e1) {
					
						e1.printStackTrace();
					}
				}
				return ers_reimbursement;
			}
	
	public List<ers_reimbursement> findAll11() {
		List<ers_reimbursement> ers_reimbursement = new ArrayList<ers_reimbursement>();
				
				try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
					String query = "select * from ers_reimbursement where reimb_status_id = 1 order by reimb_id" ;
					
					//STATEMENT INTERFACE - implementation exposed via connection
					Statement statement = conn.createStatement();
					
					//ResultSet Interface - represents the result set of a DB query
					ResultSet rs = statement.executeQuery(query);

					//returns false when there are no more rows in result set
					while(rs.next()) {
						ers_reimbursement temp = new ers_reimbursement();
						temp.setReimb_id(rs.getInt(1));
						temp.setReimb_amount(rs.getInt(2));
						temp.setReimb_submitted(rs.getString(3));
						temp.setReimb_resolved(rs.getString(4));
						temp.setReimb_description(rs.getString(5));
						temp.setReimb_receipt(rs.getObject(6));
						temp.setReimb_author(rs.getInt(7));
						temp.setReimb_resolver(rs.getInt(8));
						temp.setReimb_status_id(rs.getInt(9));
						temp.setReimb_type_id(rs.getInt(10));
			
						ers_reimbursement.add(temp);
						
					}
					
				} catch (SQLException e) {
					try {
						throw new CustomException();
					} catch (CustomException e1) {
					
						e1.printStackTrace();
					}
				}
				return ers_reimbursement;
			}
	
	@Override
	public List<ers_reimbursement> findAll() {
List<ers_reimbursement> ers_reimbursement = new ArrayList<ers_reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select * from ers_reimbursement where reimb_status_id = 3 order by reimb_id" ;
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
			while(rs.next()) {
				ers_reimbursement temp = new ers_reimbursement();
				temp.setReimb_id(rs.getInt(1));
				temp.setReimb_amount(rs.getInt(2));
				temp.setReimb_submitted(rs.getString(3));
				temp.setReimb_resolved(rs.getString(4));
				temp.setReimb_description(rs.getString(5));
				temp.setReimb_receipt(rs.getObject(6));
				temp.setReimb_author(rs.getInt(7));
				temp.setReimb_resolver(rs.getInt(8));
				temp.setReimb_status_id(rs.getInt(9));
				temp.setReimb_type_id(rs.getInt(10));

				ers_reimbursement.add(temp);
				
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return ers_reimbursement;
	}

	@Override
	public ers_reimbursement findById(Integer id) {
		ers_reimbursement g = new ers_reimbursement();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 
			while(rs.next()) {
				
				g.setReimb_id(rs.getInt(1));
				g.setReimb_amount(rs.getInt(2));
				g.setReimb_submitted(rs.getString(3));
				g.setReimb_resolved(rs.getString(4));
				g.setReimb_description(rs.getString(5));
				g.setReimb_receipt(rs.getObject(6));
				g.setReimb_author(rs.getInt(7));
				g.setReimb_resolver(rs.getInt(8));
				g.setReimb_status_id(rs.getInt(9));
				g.setReimb_type_id(rs.getInt(10));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public List<ers_reimbursement> findByUsername1(String username) {
		List<ers_reimbursement> ers_reimbursement = new ArrayList<ers_reimbursement>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_author = ? order by reimb_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ers_user eu = new ers_user();
			ErsUserDao eud= new ErsUserDao();
			eu = eud.findByUsername(username);
			ps.setInt(1, eu.getErs_users_id());
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				ers_reimbursement g = new ers_reimbursement();
				g.setReimb_id(rs.getInt(1));
				g.setReimb_amount(rs.getInt(2));
				g.setReimb_submitted(rs.getString(3));
				g.setReimb_resolved(rs.getString(4));
				g.setReimb_description(rs.getString(5));
				g.setReimb_receipt(rs.getObject(6));
				g.setReimb_author(rs.getInt(7));
				g.setReimb_resolver(rs.getInt(8));
				g.setReimb_status_id(rs.getInt(9));
				g.setReimb_type_id(rs.getInt(10));
				ers_reimbursement.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ers_reimbursement;
		
	}
	
	@Override
	public ers_reimbursement findByUsername(Integer String) {
	
		return null;
	}

	@Override
	public ers_reimbursement save(ers_reimbursement obj) {

		try(Connection conn = EXAMPLE.Project_1_William_Robinson.ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
		
String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, " +
		 "reimb_description, reimb_receipt, reimb_author, " +
				"reimb_resolver, reimb_status_id, reimb_type_id)" +
"values(?,systimestamp,systimestamp,?, ?, ?, null,3,?)";

			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
		
			ps.setInt(1, obj.getReimb_amount());
			ps.setString(2, obj.getReimb_description());
			if (obj.getReimb_receipt().toString() == "") {
			ps.setObject(3, null);
	          ps.setInt(4, obj.getReimb_author());
				ps.setInt(5, obj.getReimb_type_id());
				ps.executeUpdate();
				conn.commit();
				conn.close();
		    }
		    	File image = new File(obj.getReimb_receipt().toString());
					FileInputStream   fis = new FileInputStream(image);
				    ps.setBinaryStream(3, fis, (int) image.length());
			          ps.setInt(4, obj.getReimb_author());
						ps.setInt(5, obj.getReimb_type_id());
						ps.executeUpdate();
						conn.commit();
						fis.close();
						conn.close();
	} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}


	public ers_reimbursement update(ers_reimbursement obj, int status_id, int reimb_author) {
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql ="update ers_reimbursement set reimb_resolved=systimestamp, reimb_resolver=3, reimb_status_id=?"+
			"where reimb_author=? and reimb_status_id=3";
		
			obj.setReimb_status_id(status_id);
			obj.setReimb_author(reimb_author);
			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
	
			ps.setInt(1, obj.getReimb_status_id());
			ps.setInt(2, obj.getReimb_author());
		
			
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}
	
	public ers_reimbursement update2(ers_reimbursement obj,int res, int rid) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = SYSTIMESTAMP, " +
			"REIMB_RESOLVER = ?, REIMB_STATUS_ID = 2 WHERE REIMB_ID = ?";
			obj.setReimb_id(rid);
			obj.setReimb_resolver(res);
			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setInt(1, (obj.getReimb_resolver()));
			ps.setInt(2, obj.getReimb_id());
			
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public ers_reimbursement update1(ers_reimbursement obj,int res, int rid) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = SYSTIMESTAMP, " +
			"REIMB_RESOLVER = ?, REIMB_STATUS_ID = 1 WHERE REIMB_ID = ?";
			obj.setReimb_id(rid);
			obj.setReimb_resolver(res);
			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setInt(1, (obj.getReimb_resolver()));
			ps.setInt(2, obj.getReimb_id());
			
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public ers_reimbursement update(ers_reimbursement obj) {
	
		return null;
	}

	@Override
	public void delete(ers_reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			CallableStatement stmt = null;
		     String sql = "{call DELETE_REIMBURSEMENT(?)}";
		      stmt = conn.prepareCall(sql);
		      stmt.setInt(1, obj.getReimb_id());
		      stmt.execute();
			conn.commit();
			stmt.close();
		      conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public List<ers_reimbursement> findAll1() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Blob getImage(int reimb_id) throws SQLException {
		ResultSet rs;
		ers_reimbursement obj = new ers_reimbursement();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			obj.setReimb_id(reimb_id);
			String sql = "select reimb_receipt from ers_reimbursement where reimb_id =?";
			try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getReimb_id());
			rs = ps.executeQuery();
			rs.next();
			 java.sql.Blob blob = rs.getBlob(1);

			 return blob;
			}
			 finally {
			    conn.close();
			 }

		
	}
	
	}
}

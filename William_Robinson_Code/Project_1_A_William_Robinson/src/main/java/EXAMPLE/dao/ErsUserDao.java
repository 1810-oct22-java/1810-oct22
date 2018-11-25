package EXAMPLE.dao;
import java.util.List;


import EXAMPLE.CustomException.CustomException;
//import EXAMPLE.pojos.ers_user;
//import EXAMPLE.pojos.ers_user;
import EXAMPLE.Project_1_William_Robinson.ConnectionFactory;
import oracle.jdbc.internal.OracleTypes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import EXAMPLE.pojos.ers_user;
import EXAMPLE.service.Hash;

public class ErsUserDao implements DAO<ers_user, Integer>{


	public List<ers_user> findAll1() {
List<ers_user> ers_users = new ArrayList<ers_user>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String query = "select ers_users_id, ers_username, user_first_name, user_last_name, user_email, user_role_id from ers_users" ;
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
			while(rs.next()) {
				ers_user temp = new ers_user();
				temp.setErs_users_id(rs.getInt(1));
				temp.setErs_username(rs.getString(2));
				temp.setUser_first_name(rs.getString(3));
				temp.setUser_last_name(rs.getString(4));
				temp.setUser_email(rs.getString(5));
				temp.setUser_role_id(rs.getInt(6));
				ers_users.add(temp);
				
			}
			
		} catch (SQLException e) {
			try {
				throw new CustomException();
			} catch (CustomException e1) {
			
				e1.printStackTrace();
			}
		}
		return ers_users;
	}
	
	
	@Override
	public List<ers_user> findAll() {
List<ers_user> ers_users = new ArrayList<ers_user>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from ers_users";
			
			//STATEMENT INTERFACE - implementation exposed via connection
			Statement statement = conn.createStatement();
			
			//ResultSet Interface - represents the result set of a DB query
			ResultSet rs = statement.executeQuery(query);

			//returns false when there are no more rows in result set
			while(rs.next()) {
				ers_user temp = new ers_user();
				temp.setErs_users_id(rs.getInt(1));
				temp.setErs_username(rs.getString(2));
				temp.setErs_password(rs.getString(3));
				temp.setUser_first_name(rs.getString(4));
				temp.setUser_last_name(rs.getString(5));
				temp.setUser_email(rs.getString(6));
				temp.setUser_role_id(rs.getInt(7));
				ers_users.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ers_users;
	}
	
	
	public ers_user findById1(Integer id, Integer id2) {
		ers_user g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from ers_users where ers_users_id = ? and user_role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ps.setInt(2, id2);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				g = new ers_user();
				g.setErs_users_id(rs.getInt(1));
				g.setErs_username(rs.getString(2));
				g.setErs_password(rs.getString(3));
				g.setUser_first_name(rs.getString(4));
				g.setUser_last_name(rs.getString(5));
				g.setUser_email(rs.getString(6));
				g.setUser_role_id(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	

	@Override
	public ers_user findById(Integer id) {
		ers_user g = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from ers_users where ers_users_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				g = new ers_user();
				g.setErs_users_id(rs.getInt(1));
				g.setErs_username(rs.getString(2));
				g.setErs_password(rs.getString(3));
				g.setUser_first_name(rs.getString(4));
				g.setUser_last_name(rs.getString(5));
				g.setUser_email(rs.getString(6));
				g.setUser_role_id(rs.getInt(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	
	public ers_user findByUsername(String ers_username) {
		ers_user ers_user = new ers_user();
		//u.setUsername(username);
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id from ers_users where ers_username = ? ";
			PreparedStatement ps = conn.prepareStatement(sql); 
			ps.setString(1, ers_username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ers_user.setErs_users_id(rs.getInt(1));
				ers_user.setErs_username(rs.getString(2));
				ers_user.setErs_password(rs.getString(3));
				ers_user.setUser_first_name(rs.getString(4));
				ers_user.setUser_last_name(rs.getString(5));
				ers_user.setUser_email(rs.getString(6));
				ers_user.setUser_role_id(rs.getInt(7));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ers_user;
	}
	public static boolean validate(String name,String pass){
		boolean status=false; 
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){  
			conn.setAutoCommit(false);  
			      
PreparedStatement ps=conn.prepareStatement("select ers_username, ers_password from ers_users where ers_username=? and ers_password=?");  
Hash hash = new Hash(pass);
pass = hash.hashed(pass);
			ps.setString(1,name);  
			ps.setString(2,pass);      
			ResultSet rs=ps.executeQuery(); 
			status=rs.next(); 
			
//if ((rs.getString(1) != null || rs.getString(1)!="")&& (rs.getString(2)!= null|| rs.getString(2)!="")) {
	//			return false;
	//}
			          
		 
			}catch (SQLException e) {
				e.printStackTrace();
			}  
		
		return status; 
	}

	@Override
	public ers_user save(ers_user obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES(?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);//, keyNames);
			ps.setString(1, obj.getErs_username());
			ps.setString(2, obj.getErs_password());
			ps.setString(3, obj.getUser_first_name());
			ps.setString(4, obj.getUser_last_name());
			ps.setString(5, obj.getUser_email());
			ps.setInt(6, obj.getUser_role_id());
			ps.executeUpdate();
				conn.commit();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public ers_user update(ers_user obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ers_user obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ers_user findByUsername(Integer String) {
		// TODO Auto-generated method stub
		return null;
	}

}

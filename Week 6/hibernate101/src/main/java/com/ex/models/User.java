package com.ex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //this registers class as entity in database
@Table(name = "USERS")//allows further configuration of table in DB
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id //necessary for Hibernate to identify objects
	@Column(name = "USER_ID")
	@SequenceGenerator(name="U_SEQ_GEN",sequenceName="U_SEQ")
	@GeneratedValue(generator="U_SEQ_GEN",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, name="FIRST_NAME")
	private String firstname;
	
	@Column(nullable=false, name="LAST_NAME")
	private String lastname;
	
	public User() {}
	
	public User(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	
	

}

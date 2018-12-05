package com.ex.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity //registers class as entity in DB
@Table(name="USERS")//allows further configuration of Table in DB
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id //necessary for Hibernate to identify objects
	@Column(name="USER_ID")
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ")
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false, name="FIRST_NAME")
	private String firstname;
	
	@Column(nullable=false, name="LAST_NAME")
	private String lastname;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="Following", //@JoinTable is used to define the join/link table
			joinColumns=@JoinColumn(name="USER_ID"), //specify the join/linking column with the main entity
			inverseJoinColumns=@JoinColumn(name="FOLLOWING_ID")) //inverse side of the relationship 
	private Set<User> following = new HashSet<User>();
	
	//do not need to map bidirectionally, but we want to be able to search both follower and following lists 
	@ManyToMany(mappedBy="following", cascade=CascadeType.ALL) //refers to the collection on the inverse side of the relationship 
	private Set<User> followers = new HashSet<User>();
	
	public User() {}
	
	public User( String username, String password, String firstname, String lastname) {
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

	
	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	@Override
	public String toString() {
		return id + ") username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
}

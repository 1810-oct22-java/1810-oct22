package com.revature.pojos;

public class SimpleUser {
	private String username;
	private String password;
	
	public SimpleUser() {}
	
	public SimpleUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "SimpleUser [username=" + username + ", password=" + password + "]";
	}

}

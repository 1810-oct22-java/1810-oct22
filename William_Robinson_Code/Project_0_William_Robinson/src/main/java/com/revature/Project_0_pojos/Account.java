package com.revature.Project_0_pojos;
import com.revature.Project_0_William_Robinson.*;

public class Account extends Log{
    private int id;
	private String username;
	private int balance;
	private String type;
	
	public Account(){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Account [ " +" id =" + id + ", username =" + username + ", balance=" + balance + ", type =" + type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

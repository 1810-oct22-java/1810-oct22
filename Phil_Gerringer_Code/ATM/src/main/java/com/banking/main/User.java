package com.banking.main;

public class User {
	private String ID;
	private String password;
	private boolean loggedIn = false; //is user logged in
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	private double balance;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "User [" + getID() + ", " + getPassword() + ", " + 
				isLoggedIn() + ", " + getBalance() + "]";  
	}
}

package com.revature.pojos;

public class Account {

	private int accountId;
	private int userId;
	private int typeId;
	private int balance;
	
	public Account () {}
	
	public Account(int userId, int typeId, int balance) {
		
		this.userId = userId;
		this.typeId = typeId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", typeId=" + typeId + ", balance=" + balance
				+ "]";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}

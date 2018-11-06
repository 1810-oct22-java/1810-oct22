package com.revature.pojos;

public class Account {
	private int accountId;
	private int typeId;
	private int owner; 
	private int balance;
	
	public Account() {}

	public Account(int typeId, int owner, int balance) {
		super();
		this.typeId = typeId;
		this.owner = owner;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", typeId=" + typeId + ", owner=" + owner + ", balance=" + balance
				+ "]";
	}
	
	
	
}

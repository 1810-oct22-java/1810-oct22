package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.pojos.Account;

public class AccountService {

	public static AccountDAO aDao = new AccountDAO();

	public List<Account> getAllAccounts() {
		List<Account> accounts = aDao.findAll();
		if (accounts.isEmpty())
			return null;

		return accounts;
	}

	public List<Account> getAllUserAccounts(int user) {
		List<Account> accounts = aDao.findAllById(user);

		return accounts;
	}
	
	public void insertAccount(int uid, int type) {
		Account acc = new Account(type,uid,0);
		aDao.save(acc);
	}
	
	public int getBalance(int uid, int type) {
		List<Account> accounts = aDao.findAllById(uid);
		int accid = 0;
		
		for(Account a : accounts) {
			if(a.getOwner() == uid && a.getTypeId() == type) {accid = a.getAccountId();}
		}
		
		int initial = aDao.findById(accid).getBalance();
		
		return initial;
	}
	
	public void updateAccount(int uid, int type, int amt, String kind) {
		int total = 0;
		int accid = 0;
		List<Account> accounts = aDao.findAllById(uid);
		for(Account a : accounts) {
			if(a.getOwner() == uid && a.getTypeId() == type) {accid = a.getAccountId();}
		}
		
		int initial = aDao.findById(accid).getBalance();
		
		if(kind.equals("dep")) { 
			total = initial + amt;
		}else {
			total = initial - amt;
		}
		
		Account acc = new Account(type,uid,total);
		aDao.update(acc);
	}

	public List<Integer> createdAccounts(int user) {
		ArrayList<Integer> accountNames = new ArrayList<Integer>();
		List<Account> allAccounts = getAllUserAccounts(user);
		if (allAccounts == null) {

		} else {
			for (Account a : allAccounts) {
				accountNames.add(a.getTypeId());
			}
		}

		return accountNames;
	}

}

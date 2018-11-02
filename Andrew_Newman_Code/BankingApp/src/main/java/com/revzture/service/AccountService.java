package com.revzture.service;

import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.DAO;
import com.revature.pojos.Account;

public class AccountService {

	public static DAO<Account,Integer> aDao = new AccountDAO();
	
	public List<Account> getAllAccounts(){
		List<Account> accounts = aDao.findAll();
		if(accounts.isEmpty()) return null;
		
		return accounts;
	}
}

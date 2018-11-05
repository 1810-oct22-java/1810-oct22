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

		if (accounts.isEmpty())
			return null;

		return accounts;
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

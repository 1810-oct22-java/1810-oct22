package com.revature.Project_0_AccountService;

import java.util.List;

import com.revature.Project_0_dao.AccountDao;
import com.revature.Project_0_dao.DAO;
import com.revature.Project_0_pojos.Account;



public class AccountService {
	static DAO<Account, Integer> bookDao = new AccountDao();
        AccountDao a = new AccountDao();
	public List<Account> getAllAccounts(){
		List<Account> accounts = a.findAll();
		if (accounts.size() == 0) return null;
		return accounts;
	}
}

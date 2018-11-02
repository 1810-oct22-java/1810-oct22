package com.revzture.service;

import java.util.List;

import com.revature.dao.AccountTypeDAO;
import com.revature.dao.DAO;
import com.revature.pojos.AccountType;

public class AccountTypeService {

	public static DAO<AccountType,Integer> acDao = new AccountTypeDAO();
	
	public List<AccountType> getAllAccountTypes(){
		List<AccountType> accTypes = null;
		return accTypes;
	}
}

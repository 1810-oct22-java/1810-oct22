package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountTypeDAO;
import com.revature.pojos.AccountType;

public class AccountTypeService {

	public static AccountTypeDAO acDao = new AccountTypeDAO();
	
	public List<AccountType> getAllAccountTypes(){
		List<AccountType> accountTypes = acDao.findAll();
		if(accountTypes.isEmpty()) return null;
		
		return accountTypes;
	}
	
	public List<String> convertToName(List<Integer> accounts){
		List<String> names = new ArrayList<String>();
		
		for(Integer i : accounts) {
			names.add(acDao.findById(i).getType());
		}
		
		return names;
	}
}

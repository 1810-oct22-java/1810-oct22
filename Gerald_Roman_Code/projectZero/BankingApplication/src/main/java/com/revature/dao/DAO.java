package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import com.revature.pojos.Account;

//public class BankingApp {}

public interface DAO<T, I extends Serializable>{
	List<T> findAll();
	T findById(I id);
	T save(T obj);
	T update(T obj);
	//List<Account> findAll(Integer id);
}
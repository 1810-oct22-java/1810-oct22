package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T,I extends Serializable> {
	
	List<T> findAll();
	T findByID(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	
	/*
	 * adding this default method so that we have the capability
	 * to instantiate our dao with our dao concrete classes
	 * with a reference to the dao interface and use this method
	 * 
	 * DAO bookDAO = new BookDao<Book, Integer>();
	 */
	default boolean isUnique(T obj) {
		return true;
	}
	
}

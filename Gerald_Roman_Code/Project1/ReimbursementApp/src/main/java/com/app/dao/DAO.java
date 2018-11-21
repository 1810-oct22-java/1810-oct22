package com.app.dao;

import java.io.Serializable;
import java.util.List;

import com.app.pojo.User;

public interface DAO<T, I extends Serializable> {

	List<T> findAll();
	T findById(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);
	
	default boolean isUnique(T obj) {
		return true;
	}
}

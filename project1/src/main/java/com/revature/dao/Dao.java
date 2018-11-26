package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, I extends Serializable> {
	List<T> findAll();
	T findById(I id);
	T save(T obj);
	T update(T obj);
	void delete(T obj);

}
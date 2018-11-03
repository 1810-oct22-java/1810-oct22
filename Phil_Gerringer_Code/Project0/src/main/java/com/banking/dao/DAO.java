/**
 * 
 */
package com.banking.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Phil
 *
 */
public interface DAO <T, I extends Serializable> {
	List<T> getAll();
	List<T> getAll(I id);
	T getByID(I id);
	T insert(T obj);
	T update(T obj);
	void delete(T obj);
}

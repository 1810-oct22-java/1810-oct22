package com.revature.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {
	
   List<T> findAll();
   T findById(I id);
   T save(T obj);
   T update(T obj);
   void delete(T obj);
   /*
    * adding this default method so that we have the apability
    * to instantiate our DAO concrete classes with a reference
    * to the DAO interface and use this mehtod
    * DAO bookDao = new BookDao<Book, Integer>()
    * */
   
   default boolean isUnique(T obj) {
	   return true;
   }
}

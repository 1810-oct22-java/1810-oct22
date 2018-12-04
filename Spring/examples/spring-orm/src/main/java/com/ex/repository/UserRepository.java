package com.ex.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.User;

@Transactional //TX Manager to be used here
@Repository
public class UserRepository {
	
	@Autowired
	SessionFactory sf;
	
	public List<User> getAllUsers(){
		return sf.getCurrentSession().createCriteria(User.class).list();
	}
	
	public User getById(int id) {
		return (User) sf.getCurrentSession().get(User.class, id);
	}
	
	public User addUser(User u) {
		int id = (Integer) sf.getCurrentSession().save(u);
		u.setId(id);
		return u;
	}
	

}

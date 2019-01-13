package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service("userService")
public class UserService {
	
	//where we would autowire DAOs
	static ArrayList<User> users = new ArrayList<User>();
	static int seq = 3;
	
	static {
		users.add(new User(1, "tairey","pass","cool beans"));
		users.add(new User(2, "newman","pass","just the worst"));
	}
	
	public List<User> getAll(){
		return users;
	}
	
	public User getById(int id) {
		return users.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}
	
	public User findByUsername(String username) {
		return users.stream().filter(t -> t.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
	}
	
	public User addUser(User u) {
		User test = findByUsername(u.getUsername());
		if (test==null) {
			u.setId(seq++);
			users.add(u);
			return u;
		}
		else {
			return null;
		}
	}
	
	public User updateUser(int id, User u) {
		User usr = getById(id);
		if (usr==null) {
			return addUser(u);
		}
		else {
			for (User us : users) {
				if (us.getId()==id) {
					us.setBio(usr.getBio());
					us.setPassword(usr.getPassword());
					us.setUsername(usr.getUsername());
					return us;
				}
			}
		}
		return null;
	}

}

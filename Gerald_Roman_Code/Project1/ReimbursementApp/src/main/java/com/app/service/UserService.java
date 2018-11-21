package com.app.service;

import com.app.dao.ReimbursementDao;
import com.app.dao.UserDao;
import com.app.pojo.Reimbursement;
import com.app.pojo.User;

public class UserService {
	static UserDao userDao = new UserDao();
	static ReimbursementDao ReimbursementDao = new ReimbursementDao();
		
	public static User newUserAccount(String Firstname, String Lastname, String Username, String Password) {
		User u = new User(Firstname,Lastname,Username,Password);
		userDao.save(u);
		return u;
	}
	public Reimbursement makeReimbursement(Reimbursement r) {
		ReimbursementDao.save(r);
		return r;
	}
 
}

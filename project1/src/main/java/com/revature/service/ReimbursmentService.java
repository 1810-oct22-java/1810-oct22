package com.revature.service;

import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.ReimbursmentDao;
import com.revature.dao.UserDao;
import com.revature.pojo.Reimbursment;
import com.revature.pojo.Users;

public class ReimbursmentService {
	
static Dao<Reimbursment, Integer> reimbDao = new ReimbursmentDao();
	
	public List<Reimbursment> getAllReimbursments(){
		List<Reimbursment> reimbs = reimbDao.findAll();
		if(reimbs.size() ==0 ) return null;
		return reimbs;
	}
	
	
	public Reimbursment getById(int id) {
		List<Reimbursment> reimb = getAllReimbursments();
		//could do enhanced for loop...
		for(Reimbursment r: reimb) {
			if(r.getId() == id) return r;
		}	
		return  null;
	}
	
	public Reimbursment addReimbursment(int id, int amount, String submitted, String resolved,
			String description, int author, int resolver, int statusId, int typeId) {
		if(id == 0) return null;
		else return reimbDao.save(new Reimbursment(id, amount, submitted, resolved, description,
				author, resolver, statusId, typeId));
	}

}

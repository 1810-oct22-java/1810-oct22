package com.revature.service;

import java.sql.Timestamp;
import java.util.List;

import com.revature.dao.ReimbDAO;
import com.revature.pojos.Reimb;

public class ReimbService {
	
	public static ReimbDAO rDao = new ReimbDAO();
	
	public static void main(String[] args) {
		System.out.println(getAllReimb());
	}
	
	public Reimb getReimb(int id) {
		return rDao.findById(id);
	}
	
	static public List<Reimb> getAllReimb() {
		return rDao.findAll(); 
	}
	
	public List<Reimb> getReimbByAuthor(int id) {
		return rDao.findAllByAuthor(id); 
	}
	
	public List<Reimb> getReimbByStatus(int id) {
		return rDao.findAllByStatus(id); 
	}
	
	public Reimb upDateReimb(int id, int resolver, int statusID) {
		Reimb u = rDao.findById(id);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		u.setResolver(resolver);
		u.setResolved(timestamp);
		u.setStatusID(statusID);
		return rDao.update(u);
	}
	
	public Reimb insertReimb(Integer amount, String desc, Integer author,int typeID) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Reimb u = new Reimb(amount, timestamp, desc, author, 1 ,typeID);
		return rDao.save(u);
	}
	
	public String getStatus(Reimb r) {
		return rDao.findStatus(r.getStatusID());
	}
	
	public String getType(Reimb r) {
		return rDao.findType(r.getTypeID());
	}
	

}

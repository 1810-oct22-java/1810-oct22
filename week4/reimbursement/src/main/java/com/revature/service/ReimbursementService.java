package com.revature.service;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;

public class ReimbursementService {
	static ReimbursementDAO rDAO = new ReimbursementDAO();
	public List<Reimbursement> getAll(){
		return rDAO.findAll();
	}
	
	public List<Reimbursement> getAll(int id){
		return rDAO.findAll(id);
	}
	
	public void changeStatus(int id, int status) {
		System.out.println("");
		rDAO.update(id,status);
	}
	
	public Reimbursement insertReimbursement(Reimbursement reimbursement) {
		return rDAO.save(reimbursement);
	}
}

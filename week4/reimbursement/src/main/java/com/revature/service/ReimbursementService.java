package com.revature.service;

import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;

public class ReimbursementService {
	static DAO<Reimbursement,Integer> rDAO = new ReimbursementDAO();
	public List<Reimbursement> getAll(){
		return rDAO.findAll();
	}
}

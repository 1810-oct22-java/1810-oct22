package com.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.DAO;
import com.app.dao.ReimbursementDao;
import com.app.pojo.Reimbursement;

public class ReimbService {
	static ReimbursementDao reimbDao = new ReimbursementDao();
	static ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	public Reimbursement addReimbursement(Double amount, String desctiption, Integer author, int typeID) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Reimbursement obj = new Reimbursement(amount, time, desctiption,author,1,typeID);
		return reimbDao.save(obj);
	}
	public static List<Reimbursement> checkAllReimbursements() {
		return reimbDao.findAll();
	}
	public static Reimbursement findUser(int id) {
		return reimbDao.findById(id);
	}

}

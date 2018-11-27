package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.ReimbursementDao;
import com.app.pojo.Reimbursement;

public class ReimbService {
	static ReimbursementDao reimbDao = new ReimbursementDao();
	static ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	public static Reimbursement addReimbursement(Reimbursement r) {
		reimbDao.save(r);
		return r;
	}
	public static List<Reimbursement> checkAllReimbursements() {
		return reimbDao.findAll();
	}
	public static Reimbursement findUser(int id) {
		return reimbDao.findById(id);
	}
}

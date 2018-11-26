package com.p1.service;

import java.sql.Timestamp;
import java.util.List;

import com.p1.dao.ReimbursementDao;
import com.p1.pojos.Reimbursement;

public class ReimbursementService {

	static ReimbursementDao reimDao = new ReimbursementDao();
	
	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Reimbursement r = new Reimbursement(38, timestamp,timestamp,"sdf",2,1,1,1);
		createReimbursement(r);
//		System.out.println(getRmbByAuthor(2));
//		System.out.println(getAllRmbs());
//		System.out.println(getRmbById(1));
	}

	public List<Reimbursement> getAllRmbs() {
		List<Reimbursement> r = reimDao.findAll();
		if (r.size() == 0) return null;
		return r;
	}
	
	public static Reimbursement createReimbursement(Reimbursement r) {
		return reimDao.create(r);
	}

	public List<Reimbursement> getRmbByAuthor(int author) {
		List<Reimbursement> r = reimDao.findByAuthor(author);
		if (r.isEmpty()) {
			return null;
		}
		return r;
	}

	public List<Reimbursement> getRmbById(int id) {
		List<Reimbursement> r = reimDao.findById(id);
		if (r.isEmpty()) {
			return null;
		}
		return r;
	}


}

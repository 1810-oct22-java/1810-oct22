package com.p1.service;

import java.sql.Timestamp;
import java.util.List;

import com.p1.dao.ReimbursementDao;
import com.p1.pojos.Reimbursement;

public class ReimbursementService {

	static ReimbursementDao reimDao = new ReimbursementDao();
	
//	public static void main(String[] args) {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		Reimbursement r = new Reimbursement(38, timestamp,timestamp,"sevefvefefvdf",2,1,1,1);
//		createReimbursement(38, timestamp, timestamp, "sddsfssd", 2,1,1,1);
//		System.out.println(getRmbByAuthor(2));
//		System.out.println(getAllRmbs());
//		System.out.println(getRmbById(1));
//	}

	public List<Reimbursement> getAllRmbs() {
		List<Reimbursement> r = reimDao.findAll();
		if (r.size() == 0) return null;
		return r;
	}
	
	public Reimbursement createReimbursement(double amount, Timestamp submitted, Timestamp resolved, String description,
			int author, int resolver, int status_id, int type_id) {
		return reimDao.create(new Reimbursement (amount, submitted, resolved, description, author, resolver, status_id, type_id));
	}

	public List<Reimbursement> getRmbByAuthor(int author) {
		List<Reimbursement> r = reimDao.findByAuthor(author);
		if (r.isEmpty()) {
			return null;
		}
		return r;
	}

	public List<Reimbursement> getRmbById(int id) {
		List<Reimbursement> r = reimDao.findById2(id);
		if (r.isEmpty()) {
			return null;
		}
		return r;
	}
	
	public static void updateStatus(int id, int status) {
		Reimbursement r = reimDao.findById(id);
		r.setStatus_id(status);
		reimDao.update(r);
	}


}

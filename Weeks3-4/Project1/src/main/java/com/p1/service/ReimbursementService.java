package com.p1.service;

import java.sql.Timestamp;
import java.util.List;

import com.p1.dao.ReimbursementDao;
import com.p1.pojos.Reimbursement;

public class ReimbursementService {

	static ReimbursementDao reimDao = new ReimbursementDao();
	
	public static void main(String[] args) {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		Reimbursement r = new Reimbursement(32,timestamp,timestamp,"sdf",2,1,1,1);
//		createReimbursement(r);
//		System.out.println(getRmbByAuthor(1));
		System.out.println(getAllRmbs());
	}

	public static List<Reimbursement> getAllRmbs() {
		List<Reimbursement> r = reimDao.findAll();
		if (r.size() == 0) return null;
		return r;
	}
	
	public static void createReimbursement(Reimbursement r) {
		reimDao.create(r);
	}

	public static List<Reimbursement> getRmbByAuthor(int author) {
		List<Reimbursement> r = reimDao.findByAuthor(author);
		if (r.isEmpty()) {
			System.out.println("hit"); 
			return null;
		}
		return r;
	}


}

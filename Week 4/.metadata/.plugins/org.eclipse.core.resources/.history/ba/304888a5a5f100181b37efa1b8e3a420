package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDao;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class ReimbursementService {
	
	static Logger log = Logger.getLogger(ReimbursementService.class);
	static ReimbursementDao rDao = new ReimbursementDao();
	
	public static List<Reimbursement> getAll() {
		List<Reimbursement> reimbs = rDao.findAll();
		return reimbs;
	}
	
	public static List<Reimbursement> getUserReimbs(User u) {
		List<Reimbursement> reimbs = rDao.findAllByID(u.getId());
		return reimbs;
	}
	
	public static void addReimbursement(Reimbursement r) {
		rDao.insert(r);
		log.trace("Added Reimbursement");
	}
	
	public static List<Reimbursement> getOldReimbs() {
		List<Reimbursement> reimbs = rDao.findPastReimbs();
		return reimbs;
	}

	public static List<Reimbursement> getPendingReimbs() {
		List<Reimbursement> reimbs = rDao.findPendingReimbs();
		return reimbs;
	}
	
}

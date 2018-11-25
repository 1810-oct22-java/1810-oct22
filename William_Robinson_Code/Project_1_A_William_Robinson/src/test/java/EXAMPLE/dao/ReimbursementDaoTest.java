package EXAMPLE.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import EXAMPLE.dao.DAO;
import EXAMPLE.dao.ReimbursementDao;
import EXAMPLE.pojos.ers_reimbursement;
import EXAMPLE.pojos.ers_user;

public class ReimbursementDaoTest extends TestCase {
	private static Logger log = Logger.getLogger(ReimbursementDaoTest.class);
	DAO<ers_reimbursement, Integer> dao;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Test
	public void test() {
		
	//	List<ers_reimbursement> ers_reimbursements = dao1.findAll();
	//	for(ers_reimbursement g : ers_reimbursements){		
	//		log.debug(g);
	//	}
	//	assertNotNull(ers_reimbursements);
	//	assertTrue(ers_reimbursements.size() > 0);
		//ers_user eu = new ers_user();
		//List<ers_reimbursement> ers_reimbursement = new ArrayList<ers_reimbursement>();
		//List<ers_reimbursement> ers_reimbursement = dao1.findByUsername1("test1");
		//ers_reimbursement ers_reimbursements1 = 
	//	ers_reimbursement ers_reimbursements1 = dao1.findById(2);
	//	for(ers_reimbursement g : ers_reimbursements1){		
			//log.debug(ers_reimbursement);
		//}
	//assertNotNull(ers_reimbursement);
		//List<ers_reimbursement> ers_reimbursement = dao1.findByUsername1("test1");
		//ers_user eu1 = new ers_user();
		ers_user eu = new ers_user();
		ErsUserDao eud = new ErsUserDao();
	//	eu = eud.findByUsername("test3");
	//	eu.getErs_users_id();	
	ReimbursementDao dao1 = new ReimbursementDao();
	ers_reimbursement ert = new ers_reimbursement();
	
	ert.setReimb_id(627);
	dao1.delete(ert);
	
//    ert = dao1.findById(513);
//	ert.setReimb_resolver(eu.getErs_users_id());
//	dao1.update1(ert ,ert.getReimb_resolver(), ert.getReimb_id());
	
		
   //  ert = dao1.findById(514);
//	ert.setReimb_resolver(eu.getErs_users_id());	
//	dao1.update2(ert,ert.getReimb_resolver(), ert.getReimb_id());
	


	
	
	
	
	//log.debug(ert);
	//}
//assertNotNull(ert);
	//  ers_reimbursement ersr = new ers_reimbursement();
	 // ersr.setReimb_amount(400);
	  //ersr.setReimb_author(1);
	  //ersr.setReimb_description("traveling from C to D");
	  //ersr.setReimb_status_id(3);
	  //ersr.setReimb_type_id(2);
	 // ersr.setReimb_resolver(reimb_resolver);
	  //ersr.setReimb_submitted();
	  
	
//	ers_reimbursement ers_reimbursements2 = dao1.save(ersr);
//	for(ers_reimbursement g : ers_reimbursements1){		
		//log.debug(ers_reimbursements2);
	//}
//assertNotNull(ers_reimbursements2);
// reimbursementdao.save() these:
//(50,systimestamp,systimestamp,'Food for event', null, 1, null,3,3)
		//(ers_users1.getUser_id() > 0);
//ReimbursementDao dao2 = new ReimbursementDao();
//ers_reimbursement ers_reimbursements3 = dao2.update(ers_reimbursements1,1, 43);
//(ers_reimbursement obj, int reimb_resolver, int status_id, int reimb_author, int reimb_type_id)
//dao2.update(ers_reimbursements3, 3, 1, 43);
//log.debug(ers_reimbursements3);
//assertNotNull(ers_reimbursements3);
	}

}

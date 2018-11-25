package EXAMPLE.dao;
import junit.framework.TestCase;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import EXAMPLE.dao.DAO;
import EXAMPLE.dao.ErsUserDao;
import EXAMPLE.pojos.ers_user;

public class ErsUserDaoTest extends TestCase {
	private static Logger log = Logger.getLogger(ErsUserDaoTest.class);
	DAO<ers_user, Integer> dao;
	
   @Before
	protected void setUp() throws Exception {
		super.setUp();
	}
   @After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	@Test
	public void test() {
		ErsUserDao dao1 = new ErsUserDao();
		List<ers_user> ers_users = dao1.findAll();
		for(ers_user g : ers_users){		
			log.debug(g);
		}
		assertNotNull(ers_users);
		assertTrue(ers_users.size() > 0);
		
		
		ers_user ers_users1 = dao1.findById(1);
	//	for(ers_user g : ers_users1){		
			log.debug(ers_users1);
		//}
	assertNotNull(ers_users1);
	
	ers_user ers_users2 = dao1.findByUsername("test1");
//	for(ers_user g : ers_users1){		
		log.debug(ers_users2);
	//}
assertNotNull(ers_users2);
		//(ers_users1.getUser_id() > 0);

boolean ers_users23 = dao1.validate("test1","test1");
//for(ers_user g : ers_users1){		
	log.debug(ers_users23);
//}
	assertTrue(ers_users23);
	}

}

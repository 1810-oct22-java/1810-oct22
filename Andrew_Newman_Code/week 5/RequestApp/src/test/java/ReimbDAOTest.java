import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.dao.ReimbDAO;
import com.revature.pojos.Reimb;

public class ReimbDAOTest {

	public static ReimbDAO rDao = new ReimbDAO();
	
	@Test
	public void test() {
		List<Reimb>reimbs =  rDao.findAll(); 
		assertNotNull(reimbs);	
	}

}

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.pojos.User;

public class UserDAOTest {

	public static UserDAO uDao = new UserDAO();
	
	@Test
	public void test() {
		User user = uDao.findById(2);
		assertNotNull(user);	
	}

}

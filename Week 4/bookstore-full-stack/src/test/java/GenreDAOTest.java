import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.DAO;
import com.revature.dao.GenreDAO;
import com.revature.pojos.Genre;

public class GenreDAOTest {
	
	DAO<Genre,Integer> dao;
	private static Logger log = Logger.getLogger(GenreDAOTest.class);
	
	@Before
	private void setUp() {
		dao = new GenreDAO();
		System.out.println("Setting up instance before test");
		// TODO Auto-generated method stub

	}
	
	@After
	private void tearDown() {
		dao = null;
		System.out.println("Tearing down instance after test");
		// TODO Auto-generated method stub

	}

	@Test
	public void test() {
		List<Genre> genres = dao.findAll();
		for (Genre g: genres) {
			log.debug(g);
		}
		assertNotNull(genres);
		assertTrue(genres.size()>0);
		
	}

}

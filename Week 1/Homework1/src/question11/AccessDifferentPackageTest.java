package question11;

import static org.junit.Assert.*;

import org.junit.Test;

import question11helper.DifferentPackage;

public class AccessDifferentPackageTest {

	@Test
	public void test() {
		DifferentPackage dp = new DifferentPackage();
		assertTrue(3.2f == dp.getHidden1());
		assertTrue(9.8f == dp.getHidden2());
	}

}

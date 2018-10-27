package com.revature.JUnit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.question8.Question8;

public class Question8Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] str = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		ArrayList<String> pals = new ArrayList<String>();
		String[] str2 = {"madam","civic","radar","sexes","kayak","refer","did"};
		for (String s : str2) {
			pals.add(s);
		}
		assertTrue(pals.equals(Question8.pal(str)));
	}

}

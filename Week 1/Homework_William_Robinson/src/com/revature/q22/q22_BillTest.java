package com.revature.q22;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class q22_BillTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		q22_Bill q22 = new q22_Bill();
		
		q22.weld(() -> 
		System.out.println("Underwater welding"));
		
	    q22_Bill q23 = new q22_Bill();
	    
	    q23.weld(() ->
	    System.out.println("Deep space welding"));
	    
	    q22_Bill q24 = new q22_Bill();
	    
	    q24.weld(() ->
	    System.out.println("Aeronautical welding"));
	    /*
	     * Underwater welding
           Deep space welding
           Aeronautical welding
	     * */
	}

}

package com.revature.q15;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.q15.SimpleCalculator;;

public class Question15Test {

	SimpleCalculator tester;

	@Before
	public void setUp() throws Exception {
		tester = new SimpleCalculator();
		System.out.println("Setting up instance before test");
	}

	@After
	public void tearDown() throws Exception {
		tester = null;
		System.out.println("In tear down method");
	}

	@Test
	public void calculatorTest() {
		
		//Used to test tester
		double op1 = 2.0;
		double op2 = -8.0;
		double op3 = 0.0;
		
		//Testing addition
		assertTrue(-6.0 == tester.addition(op1, op2));
		
		//Testing subtraction
		assertTrue(10.0 == tester.substraction(op1, op2));
		
		//Testing multiplication
		assertTrue(-16.0 == tester.multiplication(op1, op2));
		
		//Testing division
		assertTrue(-4.0 == tester.division(op2, op1));
		
		//Testing division by zero
		assertTrue(0.0 == tester.division(op1, op3));
		
		//Testing division with zero
		assertTrue(0.0 == tester.division(op3, op1));
	}
}
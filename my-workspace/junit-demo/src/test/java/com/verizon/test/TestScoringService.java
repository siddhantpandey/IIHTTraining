package com.verizon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verizon.model.Grade;
import com.verizon.service.ScoringService;

public class TestScoringService {

	ScoringService ss;
	@Before
	public void setUp() throws Exception {
		this.ss = new ScoringService();
	}

	@After
	public void tearDown() throws Exception {
		this.ss=null;
	}
	
	@Test
	public void testInputGT90(){
		double input = 91;
		Grade expectedOutput = Grade.A;
		Grade actualOutput = ss.getGrade(input);
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testInputGT80LT90(){
		double input = 89;
		Grade expectedOutput = Grade.B;
		Grade actualOutput = ss.getGrade(input);
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testInputGT70LT80(){
		double input = 78;
		Grade expectedOutput = Grade.C;
		Grade actualOutput = ss.getGrade(input);
		assertEquals(expectedOutput, actualOutput);
	}
	@Test
	public void testInputLT70(){
		double input = 69;
		Grade expectedOutput = Grade.F;
		Grade actualOutput = ss.getGrade(input);
		assertEquals(expectedOutput, actualOutput);
	}
	

	
}

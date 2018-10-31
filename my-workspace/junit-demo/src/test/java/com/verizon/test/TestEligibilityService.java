package com.verizon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verizon.service.EligibilityService;

public class TestEligibilityService {

	EligibilityService es;
	@Before
	public void setUp() throws Exception {
		this.es = new EligibilityService();
	}

	@After
	public void tearDown() throws Exception {
		this.es=null;
	}

	@Test
	public void testIsEligibleToVoteWithInvalidLowerBoundary() {
		assertFalse(es.isEligibleToVote(17));
	}
	@Test
	public void testIsEligibleToVoteWithInvalidUpperBoundary() {
		assertFalse(es.isEligibleToVote(101));
	}
	@Test
	public void testIsEligibleToVoteWithValidInput() {
		assertTrue(es.isEligibleToVote(67));
	}

}

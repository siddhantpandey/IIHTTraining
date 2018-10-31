package com.verizon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verizon.service.GreetingService;

public class TestGreetingService {

	GreetingService gs;
	@Before
	public void setUp() throws Exception {
		gs = new GreetingService();
	}

	@After
	public void tearDown() throws Exception {
		this.gs=null;
	}

	@Test
	public void testGreetForValidUserName() {
		
		String input = "Siddhant";
		
		String expectedOutput = "Hello Siddhant";
		
		String actualOuput =gs.greet(input);
		
		assertEquals(actualOuput, expectedOutput);
	}
	@Test
	public void testGreetForNullUserName() {
		
		
		
		String actualOuput =gs.greet(null);
		
		assertNull(actualOuput);
	}

}

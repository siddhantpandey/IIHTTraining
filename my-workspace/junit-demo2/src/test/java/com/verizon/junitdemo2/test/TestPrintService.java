package com.verizon.junitdemo2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.verizon.junitdemo2.service.PrintService;

public class TestPrintService {

	@Test
	public void testInput() {
		PrintService ps = new PrintService();
		String input[] = {"Siddhant","Medha","Devesh","Deepak"};
		
		String expectedOutput="success";
		
		String actualOutput=ps.printme(input);
		
		
		assertEquals(actualOutput, expectedOutput);
	}
	

}

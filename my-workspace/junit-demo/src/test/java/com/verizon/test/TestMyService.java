package com.verizon.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.verizon.service.MyService;
@RunWith(Parameterized.class)
public class TestMyService {

	private double p;
	private double r;
	private double t;
	private double expectedOutput;
	private MyService ms ;
	
	
	public TestMyService(double p, double r, double t, double o) {
		super();
		this.p = p;
		this.r = r;
		this.t = t;
		this.expectedOutput = o;
	}
	
	@Parameters
	public static Collection testData() {
		Object[][] data= {
				{-1,10.5,11,-1},
				{100000,-10.8,11,-1},
				{100000,10.8,-11,-1},
				{100000,10,10,100000}
		};
		return Arrays.asList(data);
	}

	@Before
	public void setUp() throws Exception {
		ms = new MyService();
	}

	@After
	public void tearDown() throws Exception {
		ms = null;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		assertEquals(expectedOutput,ms.simpleInterest(p,r,t),0.001);
	}

}

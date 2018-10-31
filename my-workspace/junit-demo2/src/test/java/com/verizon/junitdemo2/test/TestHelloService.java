package com.verizon.junitdemo2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verizon.junitdemo2.service.HelloService;

public class TestHelloService {

	HelloService hs;
	@Before
	public void setUp() throws Exception {
		hs=new HelloService();
	}

	@After
	public void tearDown() throws Exception {
		hs=null;
	}

	@Test
	public void test() {
		assertEquals("Hello",hs.hello());
	}

}

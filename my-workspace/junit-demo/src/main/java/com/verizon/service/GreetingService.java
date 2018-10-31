package com.verizon.service;

public class GreetingService {

	public String greet(String userName) {
		String greeting = null;
		if(userName != null)
			return "Hello "+userName;
		return greeting;
	}
}

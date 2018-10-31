package com.verizon.junitdemo2.service;

public class PrintService {

	public String printme(String names[]) {
		
		int i=0;
		for(;i<names.length;i++) {
			System.out.println(names[i]);
		}
		if(i!=0)
			return "success";
		return "failure";

	}
}

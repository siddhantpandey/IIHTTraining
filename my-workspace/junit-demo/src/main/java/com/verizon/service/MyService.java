package com.verizon.service;

public class MyService {

	public double simpleInterest(double p,double r,double t) {
		if(p<0 || r<0 || t<0)
			return -1;
		return (p*r*t)/100;
	}
	public double getPayableAmount(double p,double r,double t) {
		if(p<0 || r<0 || t<0)
			return -1;
		return p+(p*r*t)/100;
	}
}

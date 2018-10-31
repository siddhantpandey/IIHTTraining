package com.verizon.ui;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingDemo {

	public static void main(String[] args) {
		PropertyConfigurator.configure("D:/my-workspace/log-demo/src/main/resources/log4j.properties");
		//BasicConfigurator.configure();
		
		Logger rootLog = Logger.getRootLogger();
		rootLog.info("Preparing For A Date");
		rootLog.debug("Carrying Credit Cards: YES");
		rootLog.warn("Are You Forgetting Something? DEO");
		rootLog.error("Not Dressed Impressivly");
		rootLog.fatal("Lost His/Her Number");
		Logger drivingLog = Logger.getLogger("Driving");
		drivingLog.info("Preparing For a ride");
		drivingLog.debug("Got The Keys? YES");
		drivingLog.warn("Are You Forgetting Soemthing? Helmat");
		drivingLog.error("Head Light Functioning Failed");
		drivingLog.fatal("Tank Empty");
		System.out.println("Demo Complete");
		}
}

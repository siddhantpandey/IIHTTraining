package com.verizon.sld;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLogginfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLogginfDemoApplication.class, args);
		
		Logger logger = LoggerFactory.getLogger("someCatg");
		logger.info("Demo Log");
	}
}

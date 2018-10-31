package com.verizon.junitdemo2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPrintService.class, TestHelloService.class })
public class AllTests {

}

package com.investaSolutions.tests;

import java.util.List;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunnableTests {
	
	
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		//String path=System.getProperty("user.dir")+"\\testng.xml";
		//System.out.println("C:\\Users\\dheeraj.singh\\git\\InvTestFramework\\testng.xml");
		suites.add("C:\\Users\\dheeraj.singh\\git\\InvTestFramework\\testng.xml");//path to xml..in src
		testng.setTestSuites(suites);
		testng.run();
	}

}

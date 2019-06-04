/*package com.v7.JmeterTest;

import java.io.File;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.testng.ITestNGListener;

public class JMeterFromExistingJMX implements ITestNGListener {

	public static void startJmeter() {
		 StandardJMeterEngine jmeter = new StandardJMeterEngine();


	        // Initialize Properties, logging, locale, etc.
	        JMeterUtils.loadJMeterProperties("G:\\apache-jmeter-5.0\\apache-jmeter-5.0\\bin\\jmeter.properties");
	        JMeterUtils.setJMeterHome("G:\\apache-jmeter-5.0\\apache-jmeter-5.0");
	        //JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
	        JMeterUtils.initLocale();

	        HashTree testPlanTree;
			try {
				// Initialize JMeter SaveService
				SaveService.loadProperties();
				// Load existing .jmx Test Plan
				//FileInputStream in = new FileInputStream("G:\\apache-jmeter-5.0\\apache-jmeter-5.0\\extras\\Test.jmx");
				File in1 = new File("G:\\apache-jmeter-5.0\\apache-jmeter-5.0\\AllUserLogin\\AllUserLogin\\UsersLogin_DotNet.jmx");
				testPlanTree = SaveService.loadTree(in1);
				 // Run JMeter Test
		        jmeter.configure(testPlanTree);
		        jmeter.run();
		       
			} catch (Exception e) {
				// TODO: handle exception
			}
	         

	       
	    }
	

	
	
}
*/
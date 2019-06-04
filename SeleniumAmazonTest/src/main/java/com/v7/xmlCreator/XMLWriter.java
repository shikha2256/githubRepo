/*package com.v7.xmlCreator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class XMLWriter {


	public void createTestNgXml(Object [][] data){
		int threadcount = 0;
		//Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("TestSuite");
		mySuite.setParallel("tests");
		
		//Create a list of XmlTests and add the Xmltest you created earlier to it.
        //List<XmlTest> tests = new ArrayList<XmlTest>();
		for(int i=1;i<data.length;i++){
			if(data[i][5].toString().equalsIgnoreCase("yes")){
				//Create an instance of XmlTest and assign a name for it.
				XmlTest myTest = new XmlTest(mySuite);
				myTest.setName("Suite "+ data[i][2] + " "+ data[i][3]);
				// New list for the parameters
				Map<String, String> testParams = new HashMap<String, String>();
				// Add parameter to the list
				testParams.put("Platform", (String)data[i][1]);
				testParams.put("SuiteName", (String)data[i][2]);
				testParams.put("ClientName", (String)data[i][3]);
				testParams.put("Browser", (String)data[i][4]);
				testParams.put("BuilNo", (String)data[i][6]);
				testParams.put("LiveOnUrl", (String)data[i][7]);
				testParams.put("CoachOnUrl", (String)data[i][8]);
				
				// Add parameters to test
				myTest.setParameters(testParams);
				
				// New list for the classes
				List<XmlClass> classes = new ArrayList<XmlClass>();

				// Putting the classes to the list
				classes.add(new XmlClass("com.onlifehealth.scripts.Driver"));

				// Add classes to test
				myTest.setClasses(classes);
				threadcount++;
			}
		}
		
		mySuite.setThreadCount(threadcount);
		System.out.println(mySuite.toXml());
		// New list for the Suites
	    List<XmlSuite> suites = new ArrayList<XmlSuite>();
	 // Add suite to the list
	    suites.add(mySuite);
	    
	 // Creating the xml
	    try{
	    	
	    
	    TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG tng = new TestNG();
	    tng.setXmlSuites(suites);
	    tng.addListener(tla);
	    tng.run();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String args[]){
		
		UtilityLibrary objUtil = new UtilityLibrary();
		Object [][]arrControllerData = objUtil.getSuites();
		List<Object[]> myList = new ArrayList<Object[]>();
		
		for(int i = 1;i<arrControllerData.length;i++){
			if(arrControllerData[i][5].toString().equalsIgnoreCase("yes")){
				myList.add(arrControllerData[i]);
			}
		}
		
		
		XMLWriter testngXml = new XMLWriter();
		testngXml.createTestNgXml(arrControllerData);
	}
	
	}
	
	

*/
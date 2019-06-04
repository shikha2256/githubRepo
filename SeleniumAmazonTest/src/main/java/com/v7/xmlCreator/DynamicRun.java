package com.v7.xmlCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicRun {

	
	public static void runTestNGTest(Map<String,String> testngParams,String suitename,String testName,String className,String methodname,String listener)
	{
		 TestNG TestNG = new TestNG();   
	     XmlSuite Suite = new XmlSuite();
	     Suite.setName(suitename);
	    // Suite.addListener(listener);
		 Suite.setParallel(XmlSuite.ParallelMode.TESTS);  
		 List<XmlTest> Tests=new ArrayList<XmlTest>();
		 List<XmlClass> Class = null;
		 XmlTest Test=new XmlTest(Suite);
		 Class=new ArrayList<XmlClass>();
		 Test.setName(testName);
		 Class.add(new XmlClass(className));   
		 Test.setXmlClasses(Class); 
	     Tests.add(Test);
		 Test.setParameters(testngParams);
		 Suite.setTests(Tests);   
		 List<XmlSuite> mySuites = new ArrayList<XmlSuite>(); 
	     mySuites.add(Suite);   
			
			
			TestNG.setXmlSuites(mySuites);
			Suite.setThreadCount(3);   
	        System.out.println(Suite.toXml());
			TestNG.run();
	     
	}
	
	
	
	
	
	
	/* public static void runTestNGTest(Map<String,String> testngParams,String suitename,String testName,String className,String methodname)
	 {   
		 System.out.println("we are in runTestNGTest method of test project");
		 //Create an instance on TestNG 
	     TestNG myTestNG = new TestNG();   
	     
	     //Create an instance of XML Suite and assign a name for it. 
	      XmlSuite mySuite = new XmlSuite(); 
	      mySuite.setName(suitename); 
	      mySuite.setParallel(XmlSuite.ParallelMode.METHODS);
	      mySuite.setThreadCount(5);

	     //Create an instance of XmlTest and assign a name for it.  
	     XmlTest myTest = new XmlTest(mySuite); 
	     myTest.setName(testName);   
	     myTest.setThreadCount(5);
	     
	     //Add any parameters that you want to set to the Test. 
	     myTest.setParameters(testngParams); 
	   
	     //Create a list which can contain the classes that you want to run.
	     List<XmlClass> myClasses = new ArrayList<XmlClass>();
	     myClasses.add(new XmlClass(className));   

	     //Assign that to the XmlTest Object created earlier. 
	     myTest.setXmlClasses(myClasses);   

	     //Create a list of XmlTests and add the Xmltest you created earlier to it.
	     List<XmlTest> myTests = new ArrayList<XmlTest>(); 
	     myTests.add(myTest);   

	     //add the list of tests to your Suite. 
	     mySuite.setTests(myTests);   

	     //Add the suite to the list of suites. 
	     List<XmlSuite> mySuites = new ArrayList<XmlSuite>(); 
	     mySuites.add(mySuite);   
	     
	     //Set the list of Suites to the testNG object you created earlier. 
	     myTestNG.setXmlSuites(mySuites);
	   //  mySuite.setFileName("myTemp.xml"); 
	   //  mySuite.setThreadCount(3);   
	     myTestNG.run();

	     //Create physical XML file based on the virtual XML content 
	     for(XmlSuite suite : mySuites) 
	     {  
	         createXmlFile(suite); 
	     }   
	     System.out.println("Filerated successfully.");   
	 
	     //Print the parameter values 
	     Map<String,String> params = myTest.getParameters(); 
	     for(Map.Entry<Stringtring> entry : params.entrySet()) 
	     { 
	       System.out.println(entry.getKey() + " => " + entry.getValue()); 
	     }
	    }

	    //This method will create an Xml file based on the XmlSuite data 
	    public void createXmlFile(XmlSuite mSuite) 
	    { 
	       FileWriter writer; 
	       try { 
	            writer = new FileWriter(new File("myTemp.xml")); 
	            writer.write(mSuite.toXml()); 
	            writer.flush(); 
	            writer.close(); 
	            System.out.println(new File("myTemp.xml").getAbsolutePath           } catch (IOException e)
	            {
	              e.printStackTrace(); 
	            }
	    }*/
}

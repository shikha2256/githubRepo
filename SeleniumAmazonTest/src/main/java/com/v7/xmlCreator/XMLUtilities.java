/*package com.v7.xmlCreator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.apache.commons.io.FileUtils;

public class XMLUtilities {

	String strSnapPath =String.valueOf(" ");
	//public static Generic objGeneric=new Generic();
	public static Xls_Reader datatable = null;
	
	
	
	public Properties ReadDataFromPropertiesFile(String filePath)
	{ 	
		File file = new File(filePath);		  
		FileInputStream fileInput = null;
		try 
		{
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.getMessage();
		}
		Properties prop = new Properties();			
		//load properties file
		try
		{
			prop.load(fileInput);
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		return prop;
	}
	
	public void createReport(String strXMLpath, String strHTMLReportPath){
		String xsltUrl    = System.getProperty("user.dir")+"/Files/Project.xsl";
		//String inputUri  = System.getProperty("user.dir")+"/src/ONLIFE_AlwaysOn_iOS.xml";
		
		try {

		    TransformerFactory tFactory = TransformerFactory.newInstance();

		    Transformer transformer =
		      tFactory.newTransformer
		         (new javax.xml.transform.stream.StreamSource
		            (xsltUrl));

		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            (strXMLpath),
		       new javax.xml.transform.stream.StreamResult
		            ( new FileOutputStream(strHTMLReportPath +"//Report.html")));
		    }
		  catch (Exception e) {
		    e.printStackTrace( );
		    }
		  
	}
	
	public void CopyFolder(String srcDir, String destDir){
		File scourceDirectory = new File(srcDir);
		File destinationDirectory = new File(destDir);
		try {
			FileUtils.copyDirectory(scourceDirectory, destinationDirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath,String strBrowserName)
	public String CreateFolderWithUserDefineNameAndTime(String strAutomationFolderPath)
     
	{
		 
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String strMainString=df.format(dateobj).replace("/","").replace(":", "").replace(" ","");
        //String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strBrowserName  + "_"+strMainString.trim();
        
		String strPathToCreateSubFolder = strAutomationFolderPath +"_"+strMainString.trim();
		File file=new File(strPathToCreateSubFolder);
        file.mkdir(); 
        try {
			System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return strPathToCreateSubFolder;
     }
	 
	public String strCreateFolder(String folderPath){
		File file = new File(folderPath);
		file.mkdir();
		return folderPath;
	}
	
	public Object[][] getData(String clientName,String testName){
		
		//if(datatable == null){
			
			datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//test/resources//TestCases//"+clientName+".xls");
		//}
		
		int rows = datatable.getRowCount(testName)-1;
		if (rows<=0){
			Object[][] testdata = new Object[1][0];
			return testdata;
		}
		
		rows = datatable.getRowCount(testName);
		int cols = datatable.getColumnCount(testName);
		Object data[][] = new Object[rows][cols];
		
		for(int rowNum = 1; rowNum <= rows; rowNum++){
			for(int colNum = 0; colNum < cols; colNum++){
				data[rowNum-1][colNum] = datatable.getCellData(testName, colNum, rowNum);
			}
		}
		return data;
	}
	
	public Object[][] getSuites(){
		
		if(datatable == null){
			
			datatable = new Xls_Reader(System.getProperty("user.dir")+"//src//test/resources//TestController//Controller.xls");
		}
		
		int rows = datatable.getRowCount("Suite")-1;
		if (rows<=0){
			Object[][] testdata = new Object[1][0];
			return testdata;
		}
		
		rows = datatable.getRowCount("Suite");
		int cols = datatable.getColumnCount("Suite");
		Object data[][] = new Object[rows][cols];
		
		for(int rowNum = 1; rowNum <= rows; rowNum++){
			for(int colNum = 0; colNum < cols; colNum++){
				data[rowNum-1][colNum] = datatable.getCellData("Suite", colNum, rowNum);
			}
		}
		return data;
	}
		 
	 public String ReadFileData(String strFilePath, String strFileName)
     {
		 String strReadLineDataContent = String.valueOf(" ");
			BufferedReader bufferedReader = null;
			    try { 
				       String csvFile = strFilePath+strFileName +".csv";
				       
				       //create BufferedReader to read csv file
				       bufferedReader = new BufferedReader(new FileReader(csvFile));
				       String line = "";
				       bufferedReader.readLine(); //skips the first row				      
				   
				      while ((line = bufferedReader.readLine()) != null) {	
				    	  strReadLineDataContent = strReadLineDataContent + ","+line.replace("\"","");	
				       }
				      bufferedReader.close();
				     
				       } catch (Exception e) {
				       System.err.println("CSV file cannot be read : " + e);
				     }
         
			    return strReadLineDataContent;
         
     }
     
		 
	 public String getTimeDuration(long lngStart, long lngEnd){
		 String strDuration = null;
		 int durationSec = (int) ((lngEnd - lngStart)/1000F);
		 int totalSec=  durationSec%60;
		 int durationMin=durationSec/60;
		 int totalMin=durationMin%60;
		 int totalHrs= durationMin/60;
		 strDuration = String.valueOf(totalHrs)+" Hrs "+ String.valueOf(totalMin) +" Min " + String.valueOf(totalSec) +" Sec ";
		 return strDuration;
	 }
	 
	

		public static void writeExecLog(File logFilepath,String strLogTxt){
		      try{
		    	  
		       FileWriter fileWritter = new FileWriter("E:/ExecutionResults/DemoLog.txt", true);
		    	  
		       BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			       bufferWritter.write(strLogTxt);
			       bufferWritter.newLine();
			       bufferWritter.close();
		       
		      }catch(Exception e){
		       e.printStackTrace();
		      }
		     }	 

	
}
*/

package com.v7.SeleniumAmazonTest.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skytesters.framework.Base;
import com.skytesters.framework.DataReader;
import com.skytesters.framework.InitiateLog;
import com.v7.SeleniumAmazonTest.Page.Page_Dashboard;
import com.v7.SeleniumAmazonTest.Page.Page_Login;
import com.v7.SeleniumAmazonTest.Page.Page_Logout;

public class LoginLogout extends Base
{
	DataReader rdr = null;
	
	Page_Login lpage = null;

	Page_Logout logpage = null;
	
	Page_Dashboard dashpage = null;
	
	
	@DataProvider(name = "Authentication")
	 public static Object[][] credentials() throws Exception {
	 Object[][] testObjArray= DataReader.getTableArray(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\UserCredentials.xlsx","Sheet1");
	 return (testObjArray);
	  }
	
	@Test(priority=1,dataProvider="Authentication")
	public void TC_Login(String username,String password) {
		lpage = new Page_Login();
		InitiateLog.log.info("Performing Login");
		lpage.verifyLogin(username,password);
		dashpage = new Page_Dashboard();
		Assert.assertEquals(dashpage.at_Dashboard(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		InitiateLog.log.info("Successfully Logged In");
	}
	
	@Test(priority=2,dependsOnMethods="TC_Login")
	public void TC_Logout()
	{
		logpage = new Page_Logout();
		InitiateLog.log.info("Performing Logout");
		logpage.verifyLogout();
		Assert.assertEquals(logpage.after_logout(), "Amazon Sign In");
		InitiateLog.log.info("Successfully Logged out");
	}
}

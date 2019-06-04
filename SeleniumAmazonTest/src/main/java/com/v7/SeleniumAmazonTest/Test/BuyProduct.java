 package com.v7.SeleniumAmazonTest.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skytesters.framework.Base;
import com.skytesters.framework.DataReader;
import com.skytesters.framework.InitiateLog;
import com.v7.SeleniumAmazonTest.Page.Page_BuyProduct;
import com.v7.SeleniumAmazonTest.Page.Page_Dashboard;
import com.v7.SeleniumAmazonTest.Page.Page_Login;
import com.v7.SeleniumAmazonTest.Page.Page_Logout;

public class BuyProduct extends Base
{
	Page_Login lpage = null;

	Page_Logout logpage = null;
	
	Page_BuyProduct buyPro = null;
	
	Page_Dashboard dashpage = null;
	
	/*@DataProvider(name = "Authentication")
	 
	public static Object[][] credentials() {
	 
	return new Object[][] { { "8178386398", "880274" }, { "8178386398", "Test@123" }};
	 
	  }*/
	
	
	@DataProvider(name = "Authentication")
	 public static Object[][] credentials() throws Exception {
	 Object[][] testObjArray= DataReader.getTableArray(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\UserCredentials.xlsx","Sheet1");
	 return (testObjArray);
	  }
	
	@Test(priority=1,dataProvider="Authentication")
	public void TC_Login(String username,String password) {
		try {
			lpage = new Page_Login();
			InitiateLog.log.info("Performing Login");
			lpage.verifyLogin(username,password);
			dashpage = new Page_Dashboard();
			Assert.assertEquals(dashpage.at_Dashboard(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			InitiateLog.log.info("Successfully Logged In");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,dependsOnMethods="TC_Login")
	public void TC_BuyProduct() {
		try {
			buyPro = new Page_BuyProduct();
			InitiateLog.log.info("Performing Shopping");
			buyPro.verifyAddToCart();
			Assert.assertEquals(buyPro.getSearchedProductTitle(),"Apple iPhone X (64GB) - Space Grey");
			buyPro.addToCart();
			InitiateLog.log.info("Successfully Added a product to cart");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test(priority=3,dependsOnMethods="TC_BuyProduct")
	public void TC_Logout() {
		try {
			logpage = new Page_Logout();
			InitiateLog.log.info("Performing Logout");
			logpage.verifyLogout();
			InitiateLog.log.info("Successfully Logged out");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}

package com.v7.AndroidTest.Test;

import org.testng.annotations.Test;

import com.skytesters.framework.Base;
import com.skytesters.framework.InitiateLog;
import com.v7.AndroidTest.Page.Page_BuyProduct;
import com.v7.AndroidTest.Page.Page_Login;
import com.v7.AndroidTest.Page.Page_Logout;


public class BuyProduct extends Base{
	
	Page_Login lpage = null;

	Page_Logout logpage = null;
	
	Page_BuyProduct buyPro = null;

	@Test(priority=1)
	public void TC_Login() {
		lpage = new Page_Login();
		InitiateLog.log.info("Performing Login");
		lpage.verifyLogin();
		/*dashpage = new Page_Dashboard();
		Assert.assertEquals(dashpage.at_Dashboard(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");*/
		InitiateLog.log.info("Successfully Logged In");
	}
	
	@Test(priority=2)
	public void TC_BuyProduct() {
		buyPro = new Page_BuyProduct();
		InitiateLog.log.info("Performing Shopping");
		buyPro.verifyAddToCart();
		//Assert.assertEquals(buyPro.getSearchedProductTitle(),"Apple iPhone X (Space Grey, 3GB RAM, 64GB Storage)");
		//buyPro.addToCart();
		InitiateLog.log.info("Successfully Added a product to cart");	
	}
	
	@Test(priority=3)
	public void TC_Logout() {
		logpage = new Page_Logout();
		InitiateLog.log.info("Performing Logout");
		logpage.verifyLogout();
		InitiateLog.log.info("Successfully Logged out");
	}
}

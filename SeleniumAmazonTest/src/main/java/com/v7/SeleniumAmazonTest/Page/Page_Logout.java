package com.v7.SeleniumAmazonTest.Page;

import com.skytesters.keywords.SeleniumKeywords;

public class Page_Logout {
String currentClassName = "";
	
	public Page_Logout() 
	{
		//SeleniumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	private void clickOnLogout() {
		try {
		//	Thread.currentThread().sleep(2000);
			SeleniumKeywords.hoverAndClick(currentClassName, "HelloLink", "#nav-item-signout .nav-text");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String after_logout() {
		String text = null;
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		text=SeleniumKeywords.getPageTitle();
		return text;
	
	}
	
	public void verifyLogout() {
		clickOnLogout();
	}
}

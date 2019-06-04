package com.v7.SeleniumAmazonTest.Page;

import com.skytesters.framework.DataReader;
import com.skytesters.framework.InitiateLog;
import com.skytesters.keywords.SeleniumKeywords;

public class Page_Login {

String currentClassName = "";
	
	public Page_Login() 
	{
		//SeleniumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	private void clickOnLoginIcon() {
		try {
		SeleniumKeywords.clickBtn(currentClassName, "loginclick");
		//	SeleniumKeywords.hoverAndClick(currentClassName, "HelloLink", "#nav-flyout-ya-signin .nav-action-inner");
		} catch (Exception e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}
			
	}
	private void enterUsername(String username)
	{
		try {
			//8178386398
		SeleniumKeywords.setText(currentClassName,"emailtxt",username);
		} catch (Exception e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}
	}
	
	private void clickOnContinue()
	{
		try {
			
		SeleniumKeywords.clickBtn(currentClassName, "continue");
		} catch (Exception e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}
		
	}
	
	private void enterPassword(String password)
	{
		try {
			
		SeleniumKeywords.setText(currentClassName, "password", password);
		} catch (Exception e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}
	}
	
	private void clickLoginBtn()
	{
		try{
			SeleniumKeywords.clickBtn(currentClassName, "login");
		}
		catch(Exception e) {
			InitiateLog.log.error("Performing Login unsucessful");
		}
	}

	public void verifyLogin(String username,String password)
	{	clickOnLoginIcon();
		enterUsername(username);
		clickOnContinue();
		enterPassword(password);
		clickLoginBtn();
	}
}

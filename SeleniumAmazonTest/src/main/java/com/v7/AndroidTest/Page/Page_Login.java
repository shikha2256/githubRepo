package com.v7.AndroidTest.Page;

import com.skytesters.framework.InitiateLog;
import com.skytesters.keywords.AppiumKeywords;

public class Page_Login {

String currentClassName = "";
	
	public Page_Login() 
	{
		try {
		///AppiumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clickOnLoginIcon() {
		
			AppiumKeywords.tap(currentClassName, "loginclick");
		
			
	}
	private void enterUsername()
	{
		
			AppiumKeywords.setText(currentClassName,"emailtxt","8178386398");
		
	}
	
	private void clickOnContinue()
	{
		
			AppiumKeywords.tap(currentClassName, "continue");
		
		
	}
	
	private void enterPassword()
	{
		
			AppiumKeywords.setText(currentClassName, "password", "81783863");
		
	}
	
	private void clickLoginBtn()
	{
		
			AppiumKeywords.tap(currentClassName, "login");
		
	}

	public void verifyLogin()
	{	clickOnLoginIcon();
		enterUsername();
		clickOnContinue();
		enterPassword();
		clickLoginBtn();
	}
}

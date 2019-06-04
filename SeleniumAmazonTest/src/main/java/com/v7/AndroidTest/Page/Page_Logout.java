package com.v7.AndroidTest.Page;

import com.skytesters.framework.InitiateLog;
import com.skytesters.keywords.AppiumKeywords;


public class Page_Logout {
String currentClassName = "";
	
	public Page_Logout() 
	{
		//AppiumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	
	
	private void clickOnNavBurger() {
	
			AppiumKeywords.tap(currentClassName, "burgerIcon");
		
		//Thread.sleep(10000);
		
	}
	
	private void scrollToSetting() {
		
			AppiumKeywords.scrollAndClick("in.amazon.mShop.android.shopping:id/gno_drawer_list","android.widget.TextView","Settings");;
			//Thread.sleep(10000);
		
	}
	
	/*private void clickOnSetting() {
		try {
			AppiumKeywords.tap(currentClassName, "settingLink");
		
		Thread.sleep(10000);
		} catch (InterruptedException e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}	
	}*/
	
	private void clickOnLogout() {
		
			AppiumKeywords.tap(currentClassName, "logoutLink");
		
		
	}
	
	private void clickOnConfirmLogout() {
		
			AppiumKeywords.tap(currentClassName, "confirmLogout");
		
	
	}
	
	public void verifyLogout() {
		clickOnNavBurger();
		scrollToSetting();
		//clickOnSetting();
		clickOnLogout();
		clickOnConfirmLogout();
	}

}

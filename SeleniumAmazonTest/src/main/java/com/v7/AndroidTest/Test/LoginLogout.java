package com.v7.AndroidTest.Test;

import org.testng.annotations.Test;

import com.skytesters.framework.Base;
import com.skytesters.framework.InitiateLog;
import com.v7.AndroidTest.Page.Page_Login;
import com.v7.AndroidTest.Page.Page_Logout;


public class LoginLogout extends Base
{
	Page_Login lpage = null;

	Page_Logout logpage = null;
	
	@Test(priority=1)
	public void tc_login() {
		lpage = new Page_Login();
		InitiateLog.log.info("Performing Login");
		lpage.verifyLogin();	
		InitiateLog.log.info("Successfully Logged In");
	}
	
	@Test(priority=2)
	public void tc_logout()
	{
		logpage = new Page_Logout();
		InitiateLog.log.info("Performing Logout");
		logpage.verifyLogout();
		InitiateLog.log.info("Successfully Logged out");
	}
}

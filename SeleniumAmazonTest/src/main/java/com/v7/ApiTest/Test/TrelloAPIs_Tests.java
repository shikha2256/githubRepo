package com.v7.ApiTest.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.skytesters.framework.BaseAPI;
import com.v7.ApiTest.Page.MemberAPIs_Page;

public class TrelloAPIs_Tests extends BaseAPI{
	
	
	@Test(priority=1)
	public void TC_GetUserName() {
		MemberAPIs_Page mpage = new MemberAPIs_Page();
		String username = mpage.getUserName();
		Assert.assertEquals(username, "deepaksharma91");
			
	}
	
	@Test(priority=2)
	public void TC_VerifyMemberBoardAPI()
	{
		MemberAPIs_Page mpage = new MemberAPIs_Page();
		String firstboardname = mpage.getBoardMemberData(0);
		Assert.assertEquals(firstboardname, "Campus Activities");
		
	}
	
	@Test(priority=3)
	public void TC_VerifyResponseOfMemberBoardAPI_InvalidToken()
	{
		MemberAPIs_Page mpage = new MemberAPIs_Page();
		String[] invalidtokendata = mpage.getBoardMemberInvalidToken();
		Assert.assertEquals(invalidtokendata[0] , "invalid token");
		Assert.assertEquals(invalidtokendata[1] , "401");
		
	}
	
}

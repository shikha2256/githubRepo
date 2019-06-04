package com.v7.SeleniumAmazonTest.Page;

import com.skytesters.keywords.SeleniumKeywords;

public class Page_Dashboard {
String currentClassName = "";
	
	public Page_Dashboard() 
	{
		//SeleniumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	public String at_Dashboard() {
		String text = "";
		text=SeleniumKeywords.getPageTitle();
		return text;
	}
}

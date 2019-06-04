package com.v7.GalenTest.Page;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;

import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import com.skytesters.framework.Config;
import com.skytesters.framework.InitiateLog;
import com.skytesters.keywords.GalenKeywords;

public class Page_LayoutTest {

	String currentClassName = "";
	
	public Page_LayoutTest() {
		GalenKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	
	
	public void check_layout() {
		try {
			GalenKeywords.checkLayout("homepage.gspec","desktop");
		}
		catch(Exception e) {
			InitiateLog.log.error("invalid");
			e.printStackTrace();
		}
	}
	
}

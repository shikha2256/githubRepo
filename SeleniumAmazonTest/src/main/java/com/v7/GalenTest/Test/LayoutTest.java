package com.v7.GalenTest.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.skytesters.framework.Base;
import com.v7.GalenTest.Page.Page_LayoutTest;

public class LayoutTest extends Base {

	Page_LayoutTest layout = null;
	
	@Test
	 public void homePageLayoutTest() throws IOException
    {
		layout = new Page_LayoutTest();
		layout.check_layout();
    
    }
	
}

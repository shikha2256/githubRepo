package com.SkyTesters.onlifehealth.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SkyTesters.onlifehealth.pages.FillTrackerPage;
import com.SkyTesters.onlifehealth.pages.LoginPage;
import com.SkyTesters.onlifehealth.pages.LogoutPage;

public class LoginTest {

	private WebDriver driver;
	
	@BeforeTest
	public void setupDriver() {
		//set path
		System.setProperty("webdriver.chrome.driver", "/home/projects/onlifehealth/src/main/resources/drivers/chromedriver.exe");
		this.driver=new ChromeDriver();
	}
	
	@Test(priority=1)
	public void loginPageTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo();
		loginPage.enterUserDetails("htshikha", "Password1");
		loginPage.submit();
	}
	@Test(priority=2,dependsOnMethods="loginPageTest")
	public void addRemoveTest() throws Exception {
		FillTrackerPage trackerPage = new FillTrackerPage(driver);
		trackerPage.addRemove();
		trackerPage.viewAll();
		trackerPage.clickNutrition();
		String firstItem=trackerPage.getFirstItem();
		Assert.assertEquals(firstItem,"Fitbit");
		String secondItem=trackerPage.getSecondItem();
		Assert.assertEquals(secondItem,"MyFitnessPal");
		Thread.sleep(2000);
	}
	@Test(priority=3,dependsOnMethods="addRemoveTest")
	public void logout() throws InterruptedException {
		LogoutPage lg=new LogoutPage(driver);
		lg.clickLogo();
		lg.clickLogoutIcon();
		lg.clickLogout();
	}
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
	
	
		
	
}
